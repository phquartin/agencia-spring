package com.agencia.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserModel id_user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String number;

    //TODO: Preciso definir como vou desenvolver a logica de documentos (CPF ou Passaporte)
    @Column(nullable = false, unique = true)
    private TypeClient typeClient;

}
