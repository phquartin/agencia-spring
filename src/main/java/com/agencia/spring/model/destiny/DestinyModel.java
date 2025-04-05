package com.agencia.spring.model.destiny;

import com.agencia.spring.model.countries.CountryModel;
import com.agencia.spring.model.vpackage.VacationPackageModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "tb_destinies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_country", nullable = false)
    private CountryModel country;

    @Column(nullable = false)
    @NotBlank(message = "O campo nome nao pode estar vazio ou em branco!")
    private String name;

    private String description;

    @ManyToMany(mappedBy = "destinies")
    @JsonIgnore
    private List<VacationPackageModel> vacationPackages;

}
