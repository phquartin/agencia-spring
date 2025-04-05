package com.agencia.spring.model.purchase;

import com.agencia.spring.model.client.ClientModel;
import com.agencia.spring.model.eservices.ExtraServicesModel;
import com.agencia.spring.model.vpackage.VacationPackageModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_client_package")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento com Cliente
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client", nullable = false)
    private ClientModel client;

    // Relacionamento com Pacote
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_package", nullable = false)
    private VacationPackageModel vacationPackage;

    @Column(nullable = false)
    private LocalDate startDate;

    // Relacionamento com os serviços contratados neste pacote
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tb_client_package_service",
            joinColumns = @JoinColumn(name = "id_client_package"),
            inverseJoinColumns = @JoinColumn(name = "id_service")
    )
    private List<ExtraServicesModel> services;
}

