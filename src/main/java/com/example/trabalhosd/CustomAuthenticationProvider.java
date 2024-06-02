package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class autenticacao implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String nome = authentication.getName();
        String pass = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(nome);
        System.out.println(authentication.getAuthorities()+ "--- " + nome+"---"+userDetails.getAuthorities());
        System.out.println(pass+"--" + userDetails.getPassword());

        if (userDetails == null || !passwordEncoder.matches(pass, userDetails.getPassword())) {
            System.out.println("erro no login " + nome);
            throw new BadCredentialsException("Nome ou palavra-passe errados");
        }

        System.out.println("deu para " + nome);
        return new UsernamePasswordAuthenticationToken(nome, pass, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
