package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.ConstanciaReserva;
import java.util.List;

public interface ConstanciaReservaService {
    List<ConstanciaReserva> listarConstancias();
    ConstanciaReserva obtenerConstanciaPorId(Long id);
    ConstanciaReserva guardarConstancia(ConstanciaReserva constanciaReserva);
    void eliminarConstancia(Long id);
    ConstanciaReserva obtenerConstanciaPorCodigo(String codigo);
}
