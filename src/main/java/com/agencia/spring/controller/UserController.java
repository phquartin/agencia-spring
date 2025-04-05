package com.agencia.spring.controller;

import com.agencia.spring.model.user.UserModel;
import com.agencia.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public List<UserModel> getUser() {
        return userService.findAll();
    }

}
