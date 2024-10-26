package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.matricula.models.OrdenPago;
import pe.cibertec.matricula.services.AlumnoService;
import pe.cibertec.matricula.services.OrdenPagoService;
import pe.cibertec.matricula.services.TesoreroService;

@Controller
@RequestMapping("/ordenes-pago")
public class OrdenPagoController {

    @Autowired
    private OrdenPagoService ordenPagoService;

    @GetMapping
    public String listarOrdenes(Model model) {
        model.addAttribute("ordenes", ordenPagoService.listarOrdenes());
        return "ordenpago/lista";
    }

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private TesoreroService tesoreroService;

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaOrden(Model model) {
        model.addAttribute("ordenPago", new OrdenPago());
        model.addAttribute("alumnos", alumnoService.listarAlumnos());
        model.addAttribute("tesoreros", tesoreroService.listarTesoreros());
        return "ordenpago/formulario";
    }

    @PostMapping
    public String guardarOrden(@ModelAttribute("ordenPago") OrdenPago ordenPago) {
        ordenPagoService.guardarOrden(ordenPago);
        return "redirect:/ordenes-pago";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarOrden(@PathVariable("id") Long id, Model model) {
        OrdenPago ordenPago = ordenPagoService.obtenerOrdenPorId(id);
        model.addAttribute("ordenPago", ordenPago);
        model.addAttribute("alumnos", alumnoService.listarAlumnos());
        model.addAttribute("tesoreros", tesoreroService.listarTesoreros());
        return "ordenpago/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarOrden(@PathVariable("id") Long id) {
        ordenPagoService.eliminarOrden(id);
        return "redirect:/ordenes-pago";
    }
}
