package org.example.room_management.service;

import org.example.room_management.document.Room;
import org.example.room_management.repository.RoomRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Flux<Room> getAllAvailableRooms(){
        return roomRepository.getRoomByAvailableTrue();
    }

    public Mono<Room> saveARoom(Room room){
        return roomRepository.save(room);
    }

    public Mono<Void> deleteARoom(String id){
        return roomRepository.deleteById(id);
    }
}
