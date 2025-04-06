package com.agencia.spring.service;

import com.agencia.spring.model.client.ClientModel;
import com.agencia.spring.repository.ClientRepository;
import groovy.util.ResourceException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    // TODO: LOGICA COM DOCUMENTO DO CLIENTE

    private final ClientRepository clientRepository;

    // CREATE

    public void save(ClientModel clientModel){

    }

    // READ

    @SneakyThrows
    public ClientModel findByUserId(Long id){
        return clientRepository.findByUserId(id).orElseThrow(() -> new ResourceException("Client not found with UserId: " + id));
    }

    @SneakyThrows
    public ClientModel findByUserUsername(String username) {
        return clientRepository.findByUserUsername(username).orElseThrow(() -> new ResourceException("Client not found with UserUsername: " + username));

    }

    // UPDATE

    // DELETE

}
