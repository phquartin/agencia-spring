package com.agencia.spring.model.client;

import com.agencia.spring.model.purchase.PurchaseModel;
import com.agencia.spring.model.user.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserModel user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String number;

    // Um cliente pode ter várias compras (pacotes)
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PurchaseModel> purchases;

    //TODO: Preciso definir como vou desenvolver a logica de documentos (CPF ou Passaporte)
    @Column(nullable = false, unique = true)
    private ClientType clientType;

}
