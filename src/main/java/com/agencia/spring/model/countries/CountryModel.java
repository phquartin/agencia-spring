package com.agencia.spring.model.countries;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_countries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String iso_code;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private Continent continent;

}
