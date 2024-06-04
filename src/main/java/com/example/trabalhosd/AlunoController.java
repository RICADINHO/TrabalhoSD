package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/addAluno")
    public String showAddAlunoForm(Model model) {
        model.addAttribute("Aluno", new Aluno());
        return "addAluno";
    }

    @PostMapping(path="/addAluno")
    public String addAluno (@ModelAttribute Aluno aluno) {
        alunoService.save(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/alunos")
    public String listarAlunos(Model model) {
        List<Aluno> alunos = alunoService.listAlunos();
        model.addAttribute("alunos", alunos);
        return "alunos";
    }

    @PostMapping("/removerAluno")
    public String removerProfessor(@RequestParam("id") Long alunoId) {
        alunoService.removerAluno(alunoId);
        return "redirect:/alunos";
    }

    @GetMapping("/editAluno/{alunoId}")
    public String showEditForm(@PathVariable Long alunoId, Model model) {
        Aluno aluno = alunoService.findAlunoById(alunoId);
        model.addAttribute("aluno", aluno);
        return "editAluno";
    }

    @PostMapping("/editAluno")
    public String editAluno(@ModelAttribute Aluno aluno) {
        alunoService.updateAluno(aluno);
        return "redirect:/alunos";
    }


}
