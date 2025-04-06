package com.agencia.spring.repository;

import com.agencia.spring.model.client.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    Optional<ClientModel> findByUserId(Long userId);
    Optional<ClientModel> findByUserUsername(String userUsername);
}
