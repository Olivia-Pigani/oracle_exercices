package org.example.user_crud.service;

import org.example.user_crud.document.User;
import org.example.user_crud.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUserById(String id) {
        return userRepository.findById(id)
                .onErrorMap(e-> new RuntimeException("the user was not found in database", e));
    }

    public Mono<User> postAUser(User newUser) {
        return userRepository.save(newUser);
    }

    public Mono<User> updateAnUser(String id, User userUpdatedData) {
        return userRepository.findById(id)
                .flatMap(u->{
                    u.setFirstName(userUpdatedData.getFirstName());
                    u.setLastName(userUpdatedData.getLastName());
                    u.setEmail(userUpdatedData.getEmail());
                    u.setActive(userUpdatedData.isActive());
                    return userRepository.save(u);
                });
    }

    public Mono<Void> deleteAUser(String id){
        return userRepository.deleteById(id);
    }
}


















