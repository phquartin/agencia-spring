package com.agencia.spring.service;

import com.agencia.spring.model.user.UserModel;
import com.agencia.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //TODO: Apagar o findAll ou deixar ele de algum jeito apenas para ADMINS (verificar se isso pode impactar a segurança).
    public List<UserModel> findAll() {return userRepository.findAll(); }

    public Optional<UserModel> findByUsername(String username) {return userRepository.findByUsername(username); }

    public UserModel save(UserModel userModel) {return userRepository.save(userModel); }

    public void delete(UserModel userModel) {userRepository.delete(userModel); }

}
