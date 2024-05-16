package com.example.trabalhosd;

import java.util.ArrayList;

public class Professor {

    private int numero;
    private int idade;
    private String nome;
    private String morada;
    private String email;
    private String telefone;
    private ArrayList<String> aulas;

    public Professor(int numero, int idade, String nome, String morada, String email, String telefone, ArrayList<String> aulas) {
        this.numero = numero;
        this.idade = idade;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
        this.aulas = aulas;
    }

    
}
