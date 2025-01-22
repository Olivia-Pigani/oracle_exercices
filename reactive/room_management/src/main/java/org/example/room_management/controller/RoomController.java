package org.example.room_management.controller;

import org.example.room_management.document.Room;
import org.example.room_management.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<Flux<Room>> getAllAvailableRooms() {
        return new ResponseEntity<>(roomService.getAllAvailableRooms(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mono<Room>> saveARoom(@RequestBody Room room) {
        return new ResponseEntity<>(roomService.saveARoom(room), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deleteARoom(@PathVariable("id") String id) {
        return new ResponseEntity<>(roomService.deleteARoom(id), HttpStatus.OK);
    }
}
