package com.agencia.spring.model.destiny;

import com.agencia.spring.model.countries.CountryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_destinies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Um destino (cidade) possui um pais, entretanto um pais possui varios destinos
    @OneToOne
    @JoinColumn(name = "id_country", nullable = false)
    private CountryModel id_country;

    @Column(nullable = false)
    private String name;

    private String description;
}
