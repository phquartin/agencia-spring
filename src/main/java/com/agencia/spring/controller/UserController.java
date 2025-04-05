package com.agencia.spring.controller;

import com.agencia.spring.model.user.UserModel;
import com.agencia.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserModel> getUser() {
        return userService.findAll();
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserModel> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel userModel) {
        return userService.save(userModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.findById(id).ifPresent(userService::delete);
        return ResponseEntity.noContent().build();
    }

}
