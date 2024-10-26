package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.FamiliarApoderado;
import java.util.List;

public interface FamiliarApoderadoService {
    List<FamiliarApoderado> listarFamiliares();
    FamiliarApoderado obtenerFamiliarPorId(Long id);
    FamiliarApoderado guardarFamiliar(FamiliarApoderado familiar);
    void eliminarFamiliar(Long id);
}
