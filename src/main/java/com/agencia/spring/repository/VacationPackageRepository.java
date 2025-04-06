package com.agencia.spring.repository;

import com.agencia.spring.model.vpackage.VacationPackageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationPackageRepository extends JpaRepository<VacationPackageModel, Long> {
}
