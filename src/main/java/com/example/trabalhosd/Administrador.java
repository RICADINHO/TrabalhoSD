package com.example.trabalhosd;

import jakarta.persistence.*;
import lombok.*;


//O @Data é uma anotação do Lombok que cria automaticamente os métodos equals, hashCode, toString, getters e setters para a classe.
//O @Entity é uma anotação do JPA que indica que a classe é uma entidade, ou seja, é uma classe que será mapeada para uma tabela na base de dados.
@Data
@Entity
public class Administrador {

    //O @Id é uma anotação do JPA que indica que o atributo é a chave primária da entidade.
    //O @GeneratedValue é uma anotação do JPA que indica que o valor do atributo será gerado automaticamente pela base de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroAdmin;
    private String nome;
    private String email;
    private String telefone;
    private String morada;
    private String password;

}
