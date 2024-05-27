package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//O @Service é uma anotação que indica que a classe é um serviço, ou seja, é responsável por implementar a lógica de negócio da aplicação.
@Service
public class AdministradorService {

    //A anotação @Autowired é utilizada para injetar uma dependência em um bean gerenciado pelo Spring.
    @Autowired
    private AdministradorRepository administradorRepository;
}
