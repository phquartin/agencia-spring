package com.agencia.spring.model.vpackage;

import com.agencia.spring.model.destiny.DestinyModel;
import com.agencia.spring.model.purchase.PurchaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_vacation_packages")
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VacationPackageType type;

    @Column(nullable = false)
    private int days;

    @Column(nullable = false)
    private boolean isActive = true;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tb_vacation_packages_destinies",
    joinColumns = @JoinColumn(name = "id_vacation_package"),
    inverseJoinColumns = @JoinColumn(name = "id_destiny")
    )
    private List<DestinyModel> destinies;

    // Um pacote pode ter várias compras de clientes diferentes

    @OneToMany(mappedBy = "vacationPackages", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PurchaseModel> clientsPurchases;

}
