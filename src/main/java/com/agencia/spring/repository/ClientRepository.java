package com.agencia.spring.repository;

import ch.qos.logback.core.net.server.Client;
import com.agencia.spring.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUserId(Long userId);
    Client findByUserUsername(String userUsername);
}
