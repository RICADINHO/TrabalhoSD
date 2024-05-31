package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

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

    public Map<String, Long> mostPopularAddresses() {
    List<Aluno> alunos = alunoRepository.findAll();
    Map<String, Long> moradaCount = new HashMap<>();
    for (Aluno aluno : alunos) {
        String morada = aluno.getMorada();
        if (moradaCount.containsKey(morada)) {
            moradaCount.put(morada, moradaCount.get(morada) + 1);
        } else {
            moradaCount.put(morada, 1L);
        }
    }
    return moradaCount.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1, LinkedHashMap::new));

}
}
