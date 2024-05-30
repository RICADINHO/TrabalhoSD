package com.example.trabalhosd;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
//@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numeroAluno;
    int idade;
    String nome;
    String curso;
    String morada;
    String email;
    String telefone;
    int nota;
    int ano;

}
