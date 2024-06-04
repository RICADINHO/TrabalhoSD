package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/addProfessor")
    public String showAddAlunoForm(Model model) {
        model.addAttribute("Professor", new Professor());
        return "addProfessor";
    }

    @PostMapping(path="/addProfessor")
    public String addProfessor (@ModelAttribute Professor professor) {
        professorService.save(professor);
        return "redirect:/professores";
    }

    @GetMapping("/professores")
    public String listarProfessores(Model model) {
        List<Professor> professores = professorService.listProfessores();
        model.addAttribute("professores", professores);
        return "professores";
    }

    @PostMapping("/removerProfessor")
    public String removerProfessor(@RequestParam("id") Long profId) {
        professorService.removerProfessor(profId);
        return "redirect:/professores";
    }

    @GetMapping("/editProfessor/{profId}")
    public String showEditForm(@PathVariable Long profId, Model model) {
        Professor professor = professorService.findProfessorById(profId);
        model.addAttribute("prof", professor);
        return "editProfessor";
    }

    @PostMapping("/editProfessor")
    public String editProfessor(@ModelAttribute Professor professor) {
        professorService.updateProfessor(professor);
        return "redirect:/professores";
    }
}
