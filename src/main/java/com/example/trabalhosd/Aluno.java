package com.example.trabalhosd;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroAluno;
    private int idade;
    private String nome;
    private String curso;
    private String morada;
    private String email;
    private String telefone;
    private int nota;
    private int ano;
}
