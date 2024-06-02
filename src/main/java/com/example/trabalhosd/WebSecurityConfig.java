package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/*
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
                        .requestMatchers("/administradores").hasRole("ADMIN")
                        .requestMatchers("/professores").hasRole("PROFESSOR")
                        .requestMatchers("/alunos").hasRole("ALUNO")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> {
            System.out.println("entrei aluno "+email);
            Aluno aluno = alunoRepository.findAll()
                    .stream()
                    .filter(a -> a.getEmail().equals(email))
                    .findFirst()
                    .orElse(null);

            if (aluno != null) {
                System.out.println("entrei aluo != null");
                return User.withUsername(aluno.getEmail())
                        .password(aluno.getPassword())
                        .roles("ALUNO")
                        .build();
            }
            System.out.println("sai aluno");
            Professor professor = professorRepository.findAll()
                    .stream()
                    .filter(p -> p.getEmail().equals(email))
                    .findFirst()
                    .orElse(null);

            if (professor != null) {
                System.out.println("entrei professor != null");
                return User.withUsername(professor.getEmail())
                        .password(professor.getPassword())
                        .roles("PROFESSOR")
                        .build();
            }

            Administrador administrador = administradorRepository.findAll()
                    .stream()
                    .filter(a -> a.getEmail().equals(email))
                    .findFirst()
                    .orElse(null);

            if (administrador != null) {
                return User.withUsername(administrador.getEmail())
                        .password(administrador.getPassword())
                        .roles("ADMIN")
                        .build();
            }

            throw new UsernameNotFoundException("User not found");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}*///----------------- ACABOUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUI
//----------------- ACABOUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUI
//----------------- ACABOUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUI
//----------------- ACABOUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUI



/*
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AdministradorRepository administradorRepository;
    @Autowired

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
                        //.requestMatchers("/administradores").hasRole("ADMINISTRADOR")
                        //.requestMatchers("/professores").hasRole("PROFESSOR")
                        //.requestMatchers("/alunos").hasRole("ALUNO")
                        //.anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //return new CustomUserDetailsService();
        UserDetails user = loadUserByUsername("email@ola.com");
        return new InMemoryUserDetailsManager(user);
    }

    //@Override

public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
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
            System.out.println("entrei aluno != null");
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username(aluno.getEmail())
                    .password(aluno.getPassword())
                    .roles("ALUNO")
                    .build();
            return user;
        }

        Professor professor = null;
        for(Professor a : professorRepository.findAll()){
            if(a.getEmail().equals(email)){
                professor = a;
                break;
            }
        }
        if (professor != null) {
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username(professor.getNome())
                    .password(professor.getPassword())
                    .roles("PROFESSOR")
                    .build();
            return user;
        }

        Administrador administrador = null;
        for(Administrador a : administradorRepository.findAll()){
            if(a.getEmail().equals(email)){
                administrador = a;
                break;
            }
        }
        if (administrador != null) {
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username(administrador.getNome())
                    .password(administrador.getPassword())
                    .roles("ADMIN")
                    .build();
            return user;
        }

        System.out.println("vai dar erro");
        throw new UsernameNotFoundException("User not found");
    }
    //@Bean
    //public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();
    //}
}*/





@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

   // @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                //.requestMatchers("/").permitAll()
                                /*.requestMatchers("/administradores").hasRole("ADMIN")
                                .requestMatchers("/professores").hasRole("PROFESSOR")*/
                                .requestMatchers("/alunos").hasRole("ADMINISTRADOR")
                                .requestMatchers("/removerAlunoFromCurso").permitAll()
                                .requestMatchers("/CursoMembros/1").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .permitAll()
                )
                .logout(logout ->
                        logout.permitAll()
                );

    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Bean
    public UserDetailsService userDetailsService() {
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
                System.out.println("entrei prfo " + professor.getEmail());
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

            System.out.println("email n existe " + email);
            throw new UsernameNotFoundException("User not found");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}