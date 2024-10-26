package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.matricula.models.Vacante;
import pe.cibertec.matricula.services.VacanteService;

@Controller
@RequestMapping("/vacantes")
public class VacanteController {

    @Autowired
    private VacanteService vacanteService;

    @GetMapping
    public String listarVacantes(Model model) {
        model.addAttribute("vacantes", vacanteService.listarVacantes());
        return "vacante/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaVacante(Model model) {
        model.addAttribute("vacante", new Vacante());
        return "vacante/formulario";
    }

    @PostMapping
    public String guardarVacante(@ModelAttribute("vacante") Vacante vacante) {
        vacanteService.guardarVacante(vacante);
        return "redirect:/vacantes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarVacante(@PathVariable("id") Long id, Model model) {
        Vacante vacante = vacanteService.obtenerVacantePorId(id);
        model.addAttribute("vacante", vacante);
        return "vacante/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVacante(@PathVariable("id") Long id) {
        vacanteService.eliminarVacante(id);
        return "redirect:/vacantes";
    }
}
