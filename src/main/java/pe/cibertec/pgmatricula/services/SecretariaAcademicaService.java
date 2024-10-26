package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.sincrud.SecretariaAcademica;
import java.util.List;

public interface SecretariaAcademicaService {
    List<SecretariaAcademica> listarSecretarias();
    SecretariaAcademica obtenerSecretariaPorId(Long id);
    SecretariaAcademica guardarSecretaria(SecretariaAcademica secretariaAcademica);
    void eliminarSecretaria(Long id);
}
