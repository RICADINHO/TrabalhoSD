package com.example.trabalhosd;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroProf;
    private String nome;
    private String morada;
    private String email;
    private String telefone;
}
