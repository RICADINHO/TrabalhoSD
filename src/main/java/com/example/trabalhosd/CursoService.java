package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

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

    public long countCursos() {
        return cursoRepository.count();
    }

    public void addAlunoToCurso(Long cursoId, Long alunoId) {
        Curso curso = cursoRepository.findById(cursoId).orElse(null);
        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
        if (curso != null && aluno != null) {
            curso.getAlunos().add(aluno);
            cursoRepository.save(curso);
            aluno.setCurso(curso.getNome());
            alunoRepository.save(aluno);
        }
    }

    public void addProfessorToCurso(Long cursoId, Long professorId) {
        Curso curso = cursoRepository.findById(cursoId).orElse(null);
        Professor professor = professorRepository.findById(professorId).orElse(null);
        if (curso != null && professor != null) {
            curso.getProfessores().add(professor);
            cursoRepository.save(curso);
        }
    }

    public void removerAlunoFromCurso(Long cursoId, Long alunoId) {
        Curso curso = cursoRepository.findById(cursoId).orElse(null);
        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
        if (curso != null && aluno != null) {
            curso.getAlunos().remove(aluno);
            cursoRepository.save(curso);
            aluno.setCurso(null);
            alunoRepository.save(aluno);
        }
    }

    public void removerProfessorFromCurso(Long cursoId, Long professorId) {
        Curso curso = cursoRepository.findById(cursoId).orElse(null);
        Professor professor = professorRepository.findById(professorId).orElse(null);
        if (curso != null && professor != null) {
            curso.getProfessores().remove(professor);
            cursoRepository.save(curso);
        }
    }

    public String cursoComMaisAlunos() {
        List<Curso> cursos = cursoRepository.findAll();
        long max = 0;
        String cursoNome = "";
        for (Curso curso : cursos) {
            if (curso.getAlunos().size() > max) {
                max = curso.getAlunos().size();
                cursoNome = curso.getNome();
            }
        }
        return cursoNome;
    }

    public List<String> cursosComAlunos() {
        List<Curso> cursos = cursoRepository.findAll();
        List<Curso> cursosComAlunos = new ArrayList<>();
        for (Curso curso : cursos) {
            if (!curso.getAlunos().isEmpty()) {
                cursosComAlunos.add(curso);
            }
        }
        List<String> cursosComAlunosNomes = new ArrayList<>();
        for (Curso curso : cursosComAlunos) {
            cursosComAlunosNomes.add(curso.getNome());
        }
        return cursosComAlunosNomes;
    }

    public String cursoComMaisHoras() {
        List<Curso> cursos = cursoRepository.findAll();
        long max = 0;
        String cursoNome = "";
        for (Curso curso : cursos) {
            if (curso.getHoras() > max) {
                max = curso.getHoras();
                cursoNome = curso.getNome();
            }
        }
        return cursoNome;
    }

    public String cursoComMaisAprovacoes() {
        List<Curso> cursos = cursoRepository.findAll();
        long max = 0;
        String cursoNome = "";
        for (Curso curso : cursos) {
            Set<Aluno> alunos = curso.getAlunos();
            long aprovacoes = 0;
            for (Aluno aluno : alunos) {
                if (aluno.getNota() >= 10.0) {
                    aprovacoes++;
                }
            }
            if (aprovacoes > max) {
                max = aprovacoes;
                cursoNome = curso.getNome();
            }
        }
        return cursoNome;
    }

    public int idadeMediaCurso(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElse(null);
        if (curso != null) {
            Set<Aluno> alunos = curso.getAlunos();
            int somaIdades = 0;
            for (Aluno aluno : alunos) {
                somaIdades += aluno.getIdade();
            }
            return somaIdades / alunos.size();
        }
        return 0;
    }
}