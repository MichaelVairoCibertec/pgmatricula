package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.sf.jasperreports.engine.*;

import pe.cibertec.matricula.models.*;
import pe.cibertec.matricula.services.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReporteController {

    @Autowired
    private OrdenPagoService ordenPagoService;

    @Autowired
    private ConstanciaMatriculaService constanciaMatriculaService;

    @Autowired
    private ConstanciaReservaService constanciaReservaService;

    @Autowired
    private ComprobantePagoService comprobantePagoService;

    @GetMapping("/reporte/generar")
    public String mostrarFormularioDeReporte(Model model) {
        model.addAttribute("tiposReporte", List.of("ordenPago", "constanciaMatricula", "constanciaReserva", "comprobantePago"));
        return "reporte";
    }

    @PostMapping("/reporte/generar")
    public String generarReporte(
            @RequestParam("tipoReporte") String tipoReporte,
            @RequestParam("codigo") String codigo,
            Model model, HttpServletResponse response) {
        try {
            String nombreArchivo = "";
            switch (tipoReporte) {
                case "ordenPago":
                    nombreArchivo = "reporte_ordenpago.pdf";
                    generarReporteOrdenPago(codigo, response, nombreArchivo);
                    break;
                case "constanciaMatricula":
                    nombreArchivo = "reporte_constanciamatricula.pdf";
                    generarReporteConstanciaMatricula(codigo, response, nombreArchivo);
                    break;
                case "constanciaReserva":
                    nombreArchivo = "reporte_constanciareserva.pdf";
                    generarReporteConstanciaReserva(codigo, response, nombreArchivo);
                    break;
                case "comprobantePago":
                    nombreArchivo = "reporte_comprobantepago.pdf";
                    generarReporteComprobantePago(codigo, response, nombreArchivo);
                    break;
                default:
                    model.addAttribute("error", "Tipo de reporte no válido");
                    return "reporte";
            }
            return "reporteResultado";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Generación Incorrecta");
            return "reporte";
        }
    }

    private void generarReporteOrdenPago(String codigo, HttpServletResponse response, String nombreArchivo) throws Exception {
        OrdenPago ordenPago = ordenPagoService.obtenerOrdenPorCodigo(codigo);
        Map<String, Object> params = new HashMap<>();
        params.put("nroOrden", ordenPago.getNro_orden());
        params.put("fechaEmision", ordenPago.getFecha_emision());
        params.put("montoTotal", ordenPago.getMonto_total());
        params.put("fechaVencimiento", ordenPago.getFecha_vencimiento());
        params.put("observaciones", ordenPago.getObservaciones());
        params.put("alumno", ordenPago.getAlumno().getNombre());
        params.put("tesorero", ordenPago.getTesorero().getNombre());
        generarReporte(response, "/reportes/OrdenPagoReporte.jrxml", params, nombreArchivo);
    }

    private void generarReporteConstanciaMatricula(String codigo, HttpServletResponse response, String nombreArchivo) throws Exception {
        ConstanciaMatricula constancia = constanciaMatriculaService.obtenerConstanciaPorCodigo(codigo);
        Map<String, Object> params = new HashMap<>();
        params.put("codigoConstanciaMatricula", constancia.getCodigo_constancia_matricula());
        params.put("fechaEmision", constancia.getFecha_emision());
        params.put("alumno", constancia.getAlumno().getNombre());
        generarReporte(response, "/reportes/ConstanciaMatriculaReporte.jrxml", params, nombreArchivo);
    }

    private void generarReporteConstanciaReserva(String codigo, HttpServletResponse response, String nombreArchivo) throws Exception {
        ConstanciaReserva constancia = constanciaReservaService.obtenerConstanciaPorCodigo(codigo);
        Map<String, Object> params = new HashMap<>();
        params.put("codigoConstanciaReserva", constancia.getCodigo_constancia_reserva());
        params.put("fechaEmision", constancia.getFecha_emision());
        params.put("alumno", constancia.getAlumno().getNombre());
        params.put("secretaria", constancia.getSecretariaAcademica().getNombre());
        generarReporte(response, "/reportes/ConstanciaReservaReporte.jrxml", params, nombreArchivo);
    }

    private void generarReporteComprobantePago(String codigo, HttpServletResponse response, String nombreArchivo) throws Exception {
        ComprobantePago comprobante = comprobantePagoService.obtenerComprobantePorCodigo(codigo);
        Map<String, Object> params = new HashMap<>();
        params.put("codigoComprobante", comprobante.getCodigoComprobante());
        params.put("montoPagado", comprobante.getMonto_pagado());
        params.put("fechaPago", comprobante.getFecha_pago());
        params.put("metodoPago", comprobante.getMetodo_pago());
        params.put("alumno", comprobante.getAlumno().getNombre());
        params.put("responsableCaja", comprobante.getResponsableCaja().getNombres());
        generarReporte(response, "/reportes/ComprobantePagoReporte.jrxml", params, nombreArchivo);
    }

    private void generarReporte(HttpServletResponse response, String jrxmlPath, Map<String, Object> params, String nombreArchivo) throws Exception {
        // Cargar la plantilla del reporte (.jrxml)
        InputStream reportStream = getClass().getResourceAsStream(jrxmlPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
        // Ejecutar el reporte con los parámetros y la conexión a la base de datos (si es necesario)
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
        // Establecer las cabeceras para la descarga del PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + nombreArchivo);
        // Exportar el reporte a la respuesta del cliente
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}
