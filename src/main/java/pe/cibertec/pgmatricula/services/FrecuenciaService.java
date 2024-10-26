package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.Frecuencia;
import java.util.List;

public interface FrecuenciaService {
    List<Frecuencia> listarFrecuencias();
    Frecuencia obtenerFrecuenciaPorId(Long id);
    Frecuencia guardarFrecuencia(Frecuencia frecuencia);
    void eliminarFrecuencia(Long id);
}
