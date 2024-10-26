package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.matricula.models.Frecuencia;
import pe.cibertec.matricula.services.FrecuenciaService;

@Controller
@RequestMapping("/frecuencias")
public class FrecuenciaController {

    @Autowired
    private FrecuenciaService frecuenciaService;

    @GetMapping
    public String listarFrecuencias(Model model) {
        model.addAttribute("frecuencias", frecuenciaService.listarFrecuencias());
        return "frecuencia/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaFrecuencia(Model model) {
        model.addAttribute("frecuencia", new Frecuencia());
        return "frecuencia/formulario";
    }

    @PostMapping
    public String guardarFrecuencia(@ModelAttribute("frecuencia") Frecuencia frecuencia) {
        frecuenciaService.guardarFrecuencia(frecuencia);
        return "redirect:/frecuencias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarFrecuencia(@PathVariable("id") Long id, Model model) {
        Frecuencia frecuencia = frecuenciaService.obtenerFrecuenciaPorId(id);
        model.addAttribute("frecuencia", frecuencia);
        return "frecuencia/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFrecuencia(@PathVariable("id") Long id) {
        frecuenciaService.eliminarFrecuencia(id);
        return "redirect:/frecuencias";
    }
}
