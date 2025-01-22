package org.example.room_management.repository;

import org.example.room_management.document.Room;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RoomRepository extends ReactiveMongoRepository<Room, String> {

    Flux<Room> getRoomByAvailableTrue();
}
