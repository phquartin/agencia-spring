package com.agencia.spring.repository;

import com.agencia.spring.model.eservice.ExtraServicesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraServiceRepository extends JpaRepository<ExtraServicesModel, Long> {
}
