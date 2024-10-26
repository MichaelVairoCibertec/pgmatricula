package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.OrdenPago;
import java.util.List;

public interface OrdenPagoService {
    List<OrdenPago> listarOrdenes();
    OrdenPago obtenerOrdenPorId(Long id);
    OrdenPago guardarOrden(OrdenPago ordenPago);
    void eliminarOrden(Long id);
    OrdenPago obtenerOrdenPorCodigo(String codigo);
}
