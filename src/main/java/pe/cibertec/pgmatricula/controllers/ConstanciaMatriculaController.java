package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.matricula.models.ConstanciaMatricula;
import pe.cibertec.matricula.services.AlumnoService;
import pe.cibertec.matricula.services.ConstanciaMatriculaService;

@Controller
@RequestMapping("/constancias-matricula")
public class ConstanciaMatriculaController {

    @Autowired
    private ConstanciaMatriculaService constanciaMatriculaService;

    @Autowired
    private AlumnoService alumnoService;  // Servicio para obtener la lista de alumnos

    @GetMapping
    public String listarConstancias(Model model) {
        model.addAttribute("constancias", constanciaMatriculaService.listarConstancias());
        return "constanciamatricula/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaConstancia(Model model) {
        model.addAttribute("constanciaMatricula", new ConstanciaMatricula());
        model.addAttribute("alumnos", alumnoService.listarAlumnos());  // Añadimos la lista de alumnos al modelo
        return "constanciamatricula/formulario";
    }

    @PostMapping
    public String guardarConstancia(@ModelAttribute("constanciaMatricula") ConstanciaMatricula constanciaMatricula) {
        constanciaMatriculaService.guardarConstancia(constanciaMatricula);
        return "redirect:/constancias-matricula";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarConstancia(@PathVariable("id") Long id, Model model) {
        ConstanciaMatricula constanciaMatricula = constanciaMatriculaService.obtenerConstanciaPorId(id);
        model.addAttribute("constanciaMatricula", constanciaMatricula);
        model.addAttribute("alumnos", alumnoService.listarAlumnos());  // Añadimos la lista de alumnos al modelo
        return "constanciamatricula/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarConstancia(@PathVariable("id") Long id) {
        constanciaMatriculaService.eliminarConstancia(id);
        return "redirect:/constancias-matricula";
    }
}
