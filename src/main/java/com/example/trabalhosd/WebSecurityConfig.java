package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class login {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    @Bean
    public UserDetailsService user_login() {
        return email -> {
            System.out.println("entrei " + email);

            Aluno aluno = null;
            for(Aluno a : alunoRepository.findAll()){
                System.out.println("entrei aluno for");
                if(a.getEmail().equals(email)){
                    System.out.println("entrei aluno check");
                    aluno = a;
                    break;
                }
            }

            if (aluno != null) {
                System.out.println("entrei aluno " + aluno.getEmail());
                return org.springframework.security.core.userdetails.User.withUsername(aluno.getEmail())
                        .password(aluno.getPassword())
                        .roles("ALUNO")
                        .build();
            }

            Professor professor = null;
            for(Professor a : professorRepository.findAll()){
                if(a.getEmail().equals(email)){
                    professor = a;
                    break;
                }
            }

            if (professor != null) {
                System.out.println("entrei prof " + professor.getEmail());
                return org.springframework.security.core.userdetails.User.withUsername(professor.getEmail())
                        .password(professor.getPassword())
                        .roles("PROFESSOR")
                        .build();
            }

            Administrador administrador = null;
            for(Administrador a : administradorRepository.findAll()){
                if(a.getEmail().equals(email)){
                    administrador = a;
                    break;
                }
            }

            if (administrador != null) {
                System.out.println("entrei adm " + administrador.getEmail());
                return org.springframework.security.core.userdetails.User.withUsername(administrador.getEmail())
                        .password((administrador.getPassword()))
                        .roles("ADMINISTRADOR")
                        .build();
            }

            System.out.println("email nao existe " + email);
            throw new UsernameNotFoundException("Utilizador nao encontrado");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}