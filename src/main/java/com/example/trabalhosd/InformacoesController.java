package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/informacoes")
public class InformacoesController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String showInformacoes(Model model) {
        long totalProfs = professorService.countProfs();
        long totalAlunos = alunoService.countAlunos();
        long totalCursos = cursoService.countCursos();

        model.addAttribute("totalProfs", totalProfs);
        model.addAttribute("totalAlunos", totalAlunos);
        model.addAttribute("totalCursos", totalCursos);

        return "informacoes";
    }

}
