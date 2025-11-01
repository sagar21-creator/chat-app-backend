package com.substring.chat.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.substring.chat.entities.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String>
 {
    // get room by roomId
    Room findByRoomId(String roomId);

    
} 