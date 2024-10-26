package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.matricula.models.Postulante;
import pe.cibertec.matricula.services.ColegioProcedenciaService;
import pe.cibertec.matricula.services.FamiliarApoderadoService;
import pe.cibertec.matricula.services.PostulanteService;
import pe.cibertec.matricula.services.TurnoHorarioService;

@Controller
@RequestMapping("/postulantes")
public class PostulanteController {

    @Autowired
    private PostulanteService postulanteService;

    @GetMapping
    public String listarPostulantes(Model model) {
        model.addAttribute("postulantes", postulanteService.listarPostulantes());
        return "postulante/lista";
    }

    @Autowired
    private TurnoHorarioService turnoHorarioService;

    @Autowired
    private FamiliarApoderadoService familiarApoderadoService;

    @Autowired
    private ColegioProcedenciaService colegioProcedenciaService;

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoPostulante(Model model) {
        model.addAttribute("postulante", new Postulante());
        model.addAttribute("turnosHorario", turnoHorarioService.listarTurnos());
        model.addAttribute("familiares", familiarApoderadoService.listarFamiliares());
        model.addAttribute("colegios", colegioProcedenciaService.listarColegios());
        return "postulante/formulario";
    }

    @PostMapping
    public String guardarPostulante(@ModelAttribute("postulante") Postulante postulante) {
        postulanteService.guardarPostulante(postulante);
        return "redirect:/postulantes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarPostulante(@PathVariable("id") Long id, Model model) {
        Postulante postulante = postulanteService.obtenerPostulantePorId(id);
        model.addAttribute("postulante", postulante);
        model.addAttribute("turnosHorario", turnoHorarioService.listarTurnos());
        model.addAttribute("familiares", familiarApoderadoService.listarFamiliares());
        model.addAttribute("colegios", colegioProcedenciaService.listarColegios());
        return "postulante/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPostulante(@PathVariable("id") Long id) {
        postulanteService.eliminarPostulante(id);
        return "redirect:/postulantes";
    }
}
