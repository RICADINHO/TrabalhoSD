package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> listProfessores() {
        return professorRepository.findAll();
    }

    public void removerProfessor(Long profId) {
        professorRepository.deleteById(profId);
    }

    public Professor findProfessorById(Long profId) {
        return professorRepository.findById(profId).orElse(null);
    }

    public void updateProfessor(Professor professor) {
        professorRepository.save(professor);
    }
}
