package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.sincrud.Tesorero;
import java.util.List;

public interface TesoreroService {
    List<Tesorero> listarTesoreros();
    Tesorero obtenerTesoreroPorId(Long id);
    Tesorero guardarTesorero(Tesorero tesorero);
    void eliminarTesorero(Long id);
}
