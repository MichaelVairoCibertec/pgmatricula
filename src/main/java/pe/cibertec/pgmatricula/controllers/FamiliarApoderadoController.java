package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.matricula.models.FamiliarApoderado;
import pe.cibertec.matricula.services.FamiliarApoderadoService;

@Controller
@RequestMapping("/familiares")
public class FamiliarApoderadoController {

    @Autowired
    private FamiliarApoderadoService familiarService;

    @GetMapping
    public String listarFamiliares(Model model) {
        model.addAttribute("familiares", familiarService.listarFamiliares());
        return "familiar/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoFamiliar(Model model) {
        model.addAttribute("familiar", new FamiliarApoderado());
        return "familiar/formulario";
    }

    @PostMapping
    public String guardarFamiliar(@ModelAttribute("familiar") FamiliarApoderado familiar) {
        familiarService.guardarFamiliar(familiar);
        return "redirect:/familiares";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarFamiliar(@PathVariable("id") Long id, Model model) {
        FamiliarApoderado familiar = familiarService.obtenerFamiliarPorId(id);
        model.addAttribute("familiar", familiar);
        return "familiar/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFamiliar(@PathVariable("id") Long id) {
        familiarService.eliminarFamiliar(id);
        return "redirect:/familiares";
    }
}
