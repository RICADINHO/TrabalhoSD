package com.example.trabalhosd;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroAdmin;
    private String nome;
    private String email;
    private String telefone;
    private String morada;
    private String password;

}
