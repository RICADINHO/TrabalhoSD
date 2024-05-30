package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador save(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public List<Administrador> listAdministradores() {
        return administradorRepository.findAll();
    }

    public void removerAdministrador(Long adminId) {
        administradorRepository.deleteById(adminId);
    }

    public Administrador findAdministradorById(Long userId) {
        return administradorRepository.findById(userId).orElse(null);
    }

    public void updateAdministrador(Administrador admin) {
        administradorRepository.save(admin);
    }
}
