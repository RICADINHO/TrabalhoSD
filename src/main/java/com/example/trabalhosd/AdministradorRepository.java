package com.example.trabalhosd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//O @Repository é uma anotação que indica que a classe é um repositório, ou seja, é responsável por fazer a comunicação com a base de dados.
@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}
