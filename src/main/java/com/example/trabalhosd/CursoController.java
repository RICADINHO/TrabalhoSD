package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
