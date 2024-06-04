package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
        String cursoComMaisAlunos = cursoService.cursoComMaisAlunos();
        List<String> cursosComAlunos = cursoService.cursosComAlunos();
        String cursoComMaisHoras = cursoService.cursoComMaisHoras();
        String cursoComMaisAprovacoes = cursoService.cursoComMaisAprovacoes();
        Map<String, Long> moradasAlunos = alunoService.mostPopularAddresses();

        model.addAttribute("totalProfs", totalProfs);
        model.addAttribute("totalAlunos", totalAlunos);
        model.addAttribute("totalCursos", totalCursos);
        model.addAttribute("cursoComMaisAlunos", cursoComMaisAlunos);
        model.addAttribute("cursosComAlunos", cursosComAlunos);
        model.addAttribute("cursoComMaisHoras", cursoComMaisHoras);
        model.addAttribute("cursoComMaisAprovacoes", cursoComMaisAprovacoes);
        model.addAttribute("moradasAlunos", moradasAlunos);

        return "informacoes";
    }

}
