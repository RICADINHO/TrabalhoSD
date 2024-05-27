package com.example.trabalhosd;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroCurso;
    private String nome;
    private int horas;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Professor professor;


}
