package com.example.trabalhosd;

import java.util.ArrayList;

public class Aluno {

    private int numero;
    private int idade;
    private String nome;
    private String curso;
    private String morada;
    private String email;
    private String telefone;
    private ArrayList<String> aulas;

    public Aluno(int numero, int idade, String nome, String curso, String morada,String email, String telefone, ArrayList<String> aulas) {
        this.numero = numero;
        this.idade = idade;
        this.nome = nome;
        this.curso = curso;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
        this.aulas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<String> getAulas() {
        return aulas;
    }

    public void setAulas(ArrayList<String> aulas) {
        this.aulas = aulas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "numero=" + numero +
                ", idade=" + idade +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                ", morada='" + morada + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", aulas=" + aulas +
                '}';
    }
}
