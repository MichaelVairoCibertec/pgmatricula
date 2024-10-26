package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.ComprobantePago;
import java.util.List;

public interface ComprobantePagoService {
    List<ComprobantePago> listarComprobantes();
    ComprobantePago obtenerComprobantePorId(Long id);
    ComprobantePago guardarComprobante(ComprobantePago comprobantePago);
    void eliminarComprobante(Long id);
    ComprobantePago obtenerComprobantePorCodigo(String codigo);
}
