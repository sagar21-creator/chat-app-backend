package com.substring.chat.controller;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import com.substring.chat.config.AppConstant;
import com.substring.chat.entities.Message;
import com.substring.chat.entities.Room;
import com.substring.chat.payload.MessageRequest;
import com.substring.chat.repositories.RoomRepository;

@Controller
@CrossOrigin(AppConstant.FRONT_END_BASE_URL)
public class ChatController {


    private RoomRepository roomRepository;

    public ChatController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

//for sending message to a room
    @MessageMapping("/sendMessage/{roomId}")   // /chat/sendMessage/{roomId}
    @SendTo("/topic/room/{roomId}")   // subscribe to this topic to receive messages
    public Message sendMessage(
        @DestinationVariable String roomId,
        @RequestBody MessageRequest request
    ) {

        Room room = roomRepository.findByRoomId(request.getRoomId());
        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimestamp(LocalDateTime.now());

        if (room != null) {
            room.getMessages().add(message);
            roomRepository.save(room);
            
        }
        else{
            //handle room not found case
            throw new RuntimeException("Room not found");
        }

        // Handle the incoming message and return the processed message
        return message;
    }
}
