package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }
    public List<Curso> listCursos() {
        return cursoRepository.findAll();
    }

    public void removerCurso(Long cursoId) {
        cursoRepository.deleteById(cursoId);
    }

    public Curso findCursoById(Long cursoId) {
        return cursoRepository.findById(cursoId).orElse(null);
    }

    public void updateCurso(Curso curso) {
        cursoRepository.save(curso);
    }

}