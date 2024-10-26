package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.matricula.models.*;
import pe.cibertec.matricula.services.*;

import java.util.List;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
    
    @Autowired
    private ColegioProcedenciaService colegioProcedenciaService;
    
    @Autowired
    private FamiliarApoderadoService familiarApoderadoService;
    
    @Autowired
    private FrecuenciaService frecuenciaService;
    
    @Autowired
    private TurnoHorarioService turnoHorarioService;
    
    @Autowired
    private VacanteService vacanteService;

    @GetMapping
    public String listarAlumnos(Model model) {
        List<Alumno> alumnos = alumnoService.listarAlumnos();
        model.addAttribute("alumnos", alumnos);
        return "alumno/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        
        // Listas para los selects
        model.addAttribute("colegios", colegioProcedenciaService.listarColegios());
        model.addAttribute("familiares", familiarApoderadoService.listarFamiliares());
        model.addAttribute("frecuencias", frecuenciaService.listarFrecuencias());
        model.addAttribute("turnos", turnoHorarioService.listarTurnos());
        model.addAttribute("vacantes", vacanteService.listarVacantes());

        return "alumno/formulario";
    }

    @PostMapping
    public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoService.guardarAlumno(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarAlumno(@PathVariable("id") Long id, Model model) {
        Alumno alumno = alumnoService.obtenerAlumnoPorId(id);
        model.addAttribute("alumno", alumno);

        // Listas para los selects
        model.addAttribute("colegios", colegioProcedenciaService.listarColegios());
        model.addAttribute("familiares", familiarApoderadoService.listarFamiliares());
        model.addAttribute("frecuencias", frecuenciaService.listarFrecuencias());
        model.addAttribute("turnos", turnoHorarioService.listarTurnos());
        model.addAttribute("vacantes", vacanteService.listarVacantes());

        return "alumno/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable("id") Long id) {
        alumnoService.eliminarAlumno(id);
        return "redirect:/alumnos";
    }
}
