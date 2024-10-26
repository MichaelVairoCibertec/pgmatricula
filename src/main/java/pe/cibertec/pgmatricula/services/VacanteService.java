package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.Vacante;
import java.util.List;

public interface VacanteService {
    List<Vacante> listarVacantes();
    Vacante obtenerVacantePorId(Long id);
    Vacante guardarVacante(Vacante vacante);
    void eliminarVacante(Long id);
}
