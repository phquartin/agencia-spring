package com.agencia.spring.model.vpackage;

import com.agencia.spring.model.destiny.DestinyModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_vacation_package")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacationPackageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private VacationPackageType type;

    @Column(nullable = false)
    private int days;

    @ManyToMany
    @JoinTable(name = "tb_vacation_package_destinies",
    joinColumns = @JoinColumn(name = "id_vacation_package"),
    inverseJoinColumns = @JoinColumn(name = "id_destiny")
    )
    private java.util.List<DestinyModel> destinies;

}
