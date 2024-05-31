package com.example.trabalhosd;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroCurso;
    private String nome;
    private int horas;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "numeroCurso")
    private Set<Aluno> alunos = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "numeroCurso")
    private Set<Professor> professores = new HashSet<>();


}
