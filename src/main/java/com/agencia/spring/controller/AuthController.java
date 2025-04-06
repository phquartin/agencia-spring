package com.agencia.spring.controller;

import com.agencia.spring.model.user.UserModel;
import com.agencia.spring.security.JwtUtil;
import com.agencia.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserModel());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute UserModel request) {

        UserModel user = userService.save(request.getUsername(), request.getPassword());
        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserModel());
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@ModelAttribute UserModel request) {
        UserModel user = userService.findByUsername(request.getUsername());
        if (user.getPassword().equals(request.getPassword())) {
            String token = JwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
