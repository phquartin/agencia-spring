package com.agencia.spring.model.eservice;

import com.agencia.spring.model.purchase.PurchaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_extra_services")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtraServicesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    private String description;

    @ManyToMany(mappedBy = "services")
    private List<PurchaseModel> client_purchases;
}
