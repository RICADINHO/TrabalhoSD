package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/addCurso")
    public String showAddCursoForm(Model model) {
        model.addAttribute("Curso", new Curso());
        return "addCurso";
    }

    @PostMapping(path="/addCurso")
    public String addCurso (@ModelAttribute Curso curso) {
        cursoService.save(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/cursos")
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoService.listCursos();
        model.addAttribute("cursos", cursos);
        return "cursos";
    }

    @PostMapping("/removerCurso")
    public String removerProfessor(@RequestParam("id") Long cursoId) {
        cursoService.removerCurso(cursoId);
        return "redirect:/cursos";
    }

    @GetMapping("/editCurso/{cursoId}")
    public String showEditForm(@PathVariable Long cursoId, Model model) {
        Curso curso = cursoService.findCursoById(cursoId);
        model.addAttribute("curso", curso);
        return "editCurso";
    }

    @PostMapping("/editCurso")
    public String editCurso(@ModelAttribute Curso curso) {
        cursoService.updateCurso(curso);
        return "redirect:/cursos";
    }


    @PostMapping("/addAlunoToCurso")
    public String addAlunoToCurso(@RequestParam("cursoId") Long cursoId, @RequestParam("alunoId") Long alunoId) {
        cursoService.addAlunoToCurso(cursoId, alunoId);
        return "redirect:/cursos";
    }

    @PostMapping("/addProfessorToCurso")
    public String addProfessorToCurso(@RequestParam("cursoId") Long cursoId, @RequestParam("professorId") Long professorId) {
        cursoService.addProfessorToCurso(cursoId, professorId);
        return "redirect:/cursos";
    }


    @PostMapping("/removerAlunoFromCurso")
    public String removerAlunoFromCurso(@RequestParam("cursoId") Long cursoId, @RequestParam("alunoId") Long alunoId) {
        cursoService.removerAlunoFromCurso(cursoId, alunoId);
        return "redirect:/cursos";
    }

    @PostMapping("/removerProfessorFromCurso")
    public String removerProfessorFromCurso(@RequestParam("cursoId") Long cursoId, @RequestParam("professorId") Long professorId) {
        cursoService.removerProfessorFromCurso(cursoId, professorId);
        return "redirect:/cursos";
    }

    @GetMapping("/cursoMembros/{cursoId}")
    public String showCursoMembros(@PathVariable Long cursoId, Model model) {
        Curso curso = cursoService.findCursoById(cursoId);
        int idadeMedia = cursoService.idadeMediaCurso(cursoId);
        model.addAttribute("curso", curso);
        model.addAttribute("idadeMedia", idadeMedia);
        return "cursoMembros";
    }

}
