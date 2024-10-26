package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.Postulante;
import java.util.List;

public interface PostulanteService {
    List<Postulante> listarPostulantes();
    Postulante obtenerPostulantePorId(Long id);
    Postulante guardarPostulante(Postulante postulante);
    void eliminarPostulante(Long id);
}
