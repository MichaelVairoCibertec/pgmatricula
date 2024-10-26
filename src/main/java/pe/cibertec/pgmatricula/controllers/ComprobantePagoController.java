package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.matricula.models.ComprobantePago;
import pe.cibertec.matricula.services.AlumnoService;
import pe.cibertec.matricula.services.ComprobantePagoService;
import pe.cibertec.matricula.services.ResponsableCajaService;

@Controller
@RequestMapping("/comprobantes-pago")
public class ComprobantePagoController {

    @Autowired
    private ComprobantePagoService comprobantePagoService;

    @Autowired
    private AlumnoService alumnoService;  // Servicio para obtener alumnos

    @Autowired
    private ResponsableCajaService responsableCajaService;  // Servicio para obtener responsables de caja

    @GetMapping
    public String listarComprobantes(Model model) {
        model.addAttribute("comprobantes", comprobantePagoService.listarComprobantes());
        return "comprobantepago/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoComprobante(Model model) {
        model.addAttribute("comprobantePago", new ComprobantePago());
        model.addAttribute("alumnos", alumnoService.listarAlumnos());  // Añadimos la lista de alumnos
        model.addAttribute("responsablesCaja", responsableCajaService.listarResponsablesCaja());  // Añadimos la lista de responsables de caja
        return "comprobantepago/formulario";
    }

    @PostMapping
    public String guardarComprobante(@ModelAttribute("comprobantePago") ComprobantePago comprobantePago) {
        comprobantePagoService.guardarComprobante(comprobantePago);
        return "redirect:/comprobantes-pago";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarComprobante(@PathVariable("id") Long id, Model model) {
        ComprobantePago comprobantePago = comprobantePagoService.obtenerComprobantePorId(id);
        model.addAttribute("comprobantePago", comprobantePago);
        model.addAttribute("alumnos", alumnoService.listarAlumnos());  // Añadimos la lista de alumnos
        model.addAttribute("responsablesCaja", responsableCajaService.listarResponsablesCaja());  // Añadimos la lista de responsables de caja
        return "comprobantepago/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarComprobante(@PathVariable("id") Long id) {
        comprobantePagoService.eliminarComprobante(id);
        return "redirect:/comprobantes-pago";
    }
}
