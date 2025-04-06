package com.agencia.spring.repository;

import com.agencia.spring.model.destiny.DestinyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinyRepository extends JpaRepository<DestinyModel, Long> {
}
