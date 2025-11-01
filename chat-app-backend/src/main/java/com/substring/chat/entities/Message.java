package com.substring.chat.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
   
    private String sender;  //ID of the user who sent the message
    private String content;  //Content of the message
    private LocalDateTime timestamp;  //Timestamp when the message was sent

    
    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}
