package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/curso")
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
        return "redirect:/curso/cursos";
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
        return "redirect:/curso/cursos";
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
        return "redirect:/curso/cursos";
    }
}
