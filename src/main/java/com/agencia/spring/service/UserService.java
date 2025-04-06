package com.agencia.spring.service;

import com.agencia.spring.model.user.UserModel;
import com.agencia.spring.repository.UserRepository;
import groovy.util.ResourceException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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
    public UserModel save(UserModel userModel) {return userRepository.save(userModel); }

    // DELETE
    @SneakyThrows
    public void deleteById(Long id) {

        if (!userRepository.existsById(id)) {
            throw new ResourceException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
    }

}
