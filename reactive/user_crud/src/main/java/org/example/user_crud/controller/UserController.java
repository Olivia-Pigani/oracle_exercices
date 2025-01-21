package org.example.user_crud.controller;

import org.example.user_crud.document.User;
import org.example.user_crud.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Flux<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<User>> getUserById(@PathVariable("id") String id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mono<User>> postAUser(@RequestBody User newUser){
        return new ResponseEntity<>(userService.postAUser(newUser), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<User>> updateAnUser(@PathVariable("id") String id, @RequestBody User userUpdatedData){
        return new ResponseEntity<>(userService.updateAnUser(id, userUpdatedData), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deleteAnUser(@PathVariable("id") String id){
        return new ResponseEntity<>(userService.deleteAUser(id),HttpStatus.ACCEPTED);
    }
}
















