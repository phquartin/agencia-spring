package com.agencia.spring.repository;

import com.agencia.spring.model.country.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryModel, Long> {
}
