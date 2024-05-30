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

    public void setNumeroAluno(Long numeroAluno) {
        this.numeroAluno = numeroAluno;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Long getNumeroAluno() {
        return numeroAluno;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getMorada() {
        return morada;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getNota() {
        return nota;
    }

    public int getAno() {
        return ano;
    }


}
