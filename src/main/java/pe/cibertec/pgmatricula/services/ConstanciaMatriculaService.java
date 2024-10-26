package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.ConstanciaMatricula;
import java.util.List;

public interface ConstanciaMatriculaService {
    List<ConstanciaMatricula> listarConstancias();
    ConstanciaMatricula obtenerConstanciaPorId(Long id);
    ConstanciaMatricula guardarConstancia(ConstanciaMatricula constanciaMatricula);
    void eliminarConstancia(Long id);
    ConstanciaMatricula obtenerConstanciaPorCodigo(String codigo);
}
