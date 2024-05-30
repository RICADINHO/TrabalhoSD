package com.example.trabalhosd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/admin")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/addAdministrador")
    public String showAddAdministradorForm(Model model) {
        model.addAttribute("Administrador", new Administrador());
        return "addAdministrador";
    }

    @PostMapping(path="/addAdministrador")
    public String addAdministrador (@ModelAttribute Administrador administrador) {
        administradorService.save(administrador);
        return "redirect:/admin/administradores";
    }

    @GetMapping("/administradores")
    public String listarAdministradores(Model model) {
        List<Administrador> administradores = administradorService.listAdministradores();
        model.addAttribute("administradores", administradores);
        return "administradores";
    }

    @PostMapping("/removerAdministrador")
    public String removerAdministrador(@RequestParam("id") Long adminId) {
        administradorService.removerAdministrador(adminId);
        return "redirect:/admin/administradores";
    }

    @GetMapping("/editAdministrador/{adminId}")
    public String showEditForm(@PathVariable Long adminId, Model model) {
        Administrador admin = administradorService.findAdministradorById(adminId);
        model.addAttribute("admin", admin);
        return "editAdministrador";
    }

    @PostMapping("/editAdministrador")
    public String editAdministrador(@ModelAttribute Administrador admin) {
        administradorService.updateAdministrador(admin);
        return "redirect:/admin/administradores";
    }
}
