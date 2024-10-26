package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.matricula.models.TurnoHorario;
import pe.cibertec.matricula.services.FrecuenciaService;
import pe.cibertec.matricula.services.TurnoHorarioService;

@Controller
@RequestMapping("/turnos-horario")
public class TurnoHorarioController {

    @Autowired
    private TurnoHorarioService turnoHorarioService;

    @GetMapping
    public String listarTurnos(Model model) {
        model.addAttribute("turnos", turnoHorarioService.listarTurnos());
        return "turnohorario/lista";
    }

    @Autowired
    private FrecuenciaService frecuenciaService;

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoTurno(Model model) {
        model.addAttribute("turnoHorario", new TurnoHorario());
        model.addAttribute("frecuencias", frecuenciaService.listarFrecuencias());
        return "turnohorario/formulario";
    }

    @PostMapping
    public String guardarTurno(@ModelAttribute("turnoHorario") TurnoHorario turnoHorario) {
        turnoHorarioService.guardarTurno(turnoHorario);
        return "redirect:/turnos-horario";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarTurno(@PathVariable("id") Long id, Model model) {
        TurnoHorario turnoHorario = turnoHorarioService.obtenerTurnoPorId(id);
        model.addAttribute("turnoHorario", turnoHorario);
        model.addAttribute("frecuencias", frecuenciaService.listarFrecuencias());
        return "turnohorario/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTurno(@PathVariable("id") Long id) {
        turnoHorarioService.eliminarTurno(id);
        return "redirect:/turnos-horario";
    }
}
