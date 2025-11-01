package com.substring.chat.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rooms")
public class Room {
    @Id
    private String id;  //Mongo db : unique id for each room
    private String roomId;  //Unique identifier for the room

    private List<Message> messages = new ArrayList<>();  //List of messages in the room

}
