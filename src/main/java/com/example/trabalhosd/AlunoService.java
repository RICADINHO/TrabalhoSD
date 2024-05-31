package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listAlunos() {
        return alunoRepository.findAll();
    }

    public void removerAluno(Long alunoId) {
        alunoRepository.deleteById(alunoId);
    }

    public Aluno findAlunoById(Long alunoId) {
        return alunoRepository.findById(alunoId).orElse(null);
    }

    public void updateAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public long countAlunos() {
        return alunoRepository.count();
    }
}
