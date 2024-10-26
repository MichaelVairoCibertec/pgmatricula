package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.matricula.models.ConstanciaReserva;
import pe.cibertec.matricula.services.AlumnoService;
import pe.cibertec.matricula.services.ConstanciaReservaService;
import pe.cibertec.matricula.services.SecretariaAcademicaService;

@Controller
@RequestMapping("/constancias-reserva")
public class ConstanciaReservaController {

    @Autowired
    private ConstanciaReservaService constanciaReservaService;

    @GetMapping
    public String listarConstancias(Model model) {
        model.addAttribute("constancias", constanciaReservaService.listarConstancias());
        return "constanciareserva/lista";
    }

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private SecretariaAcademicaService secretariaAcademicaService;

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaConstancia(Model model) {
        model.addAttribute("constanciaReserva", new ConstanciaReserva());
        model.addAttribute("alumnos", alumnoService.listarAlumnos());
        model.addAttribute("secretarias", secretariaAcademicaService.listarSecretarias());
        return "constanciareserva/formulario";
    }

    @PostMapping
    public String guardarConstancia(@ModelAttribute("constanciaReserva") ConstanciaReserva constanciaReserva) {
        constanciaReservaService.guardarConstancia(constanciaReserva);
        return "redirect:/constancias-reserva";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarConstancia(@PathVariable("id") Long id, Model model) {
        ConstanciaReserva constanciaReserva = constanciaReservaService.obtenerConstanciaPorId(id);
        model.addAttribute("constanciaReserva", constanciaReserva);
        model.addAttribute("alumnos", alumnoService.listarAlumnos());
        model.addAttribute("secretarias", secretariaAcademicaService.listarSecretarias());
        return "constanciareserva/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarConstancia(@PathVariable("id") Long id) {
        constanciaReservaService.eliminarConstancia(id);
        return "redirect:/constancias-reserva";
    }
}
