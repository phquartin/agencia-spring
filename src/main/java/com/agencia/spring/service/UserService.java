package com.agencia.spring.service;

import com.agencia.spring.model.user.UserModel;
import com.agencia.spring.repository.UserRepository;
import groovy.util.ResourceException;
import lombok.SneakyThrows;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // READ
    //TODO: Apagar o findAll ou deixar ele de algum jeito apenas para ADMINS (verificar se isso pode impactar a segurança).
    public List<UserModel> findAll() {return userRepository.findAll(); }

    @SneakyThrows
    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceException("User not found with username: " + username));
    }

    @SneakyThrows
    public UserModel findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceException("User not found with id: " + id));
    }

    // CRATE
    public UserModel save(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        UserModel userModel = UserModel.builder().username(username).password(encodedPassword).build();
        return userRepository.save(userModel);
    }

    // DELETE
    @SneakyThrows
    public void deleteById(Long id) {

        if (!userRepository.existsById(id)) {
            throw new ResourceException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
    }

}
