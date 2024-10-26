package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.sincrud.ColegioProcedencia;

import java.util.List;

public interface ColegioProcedenciaService {
    List<ColegioProcedencia> listarColegios();
    ColegioProcedencia obtenerColegioPorId(Long id);
}
