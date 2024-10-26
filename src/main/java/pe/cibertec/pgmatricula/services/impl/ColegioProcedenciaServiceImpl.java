package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.sincrud.ColegioProcedencia;
import pe.cibertec.matricula.repository.sincrud.ColegioProcedenciaRepository;
import pe.cibertec.matricula.services.ColegioProcedenciaService;

import java.util.List;

@Service
public class ColegioProcedenciaServiceImpl implements ColegioProcedenciaService {

    @Autowired
    private ColegioProcedenciaRepository colegioProcedenciaRepository;

    @Override
    public List<ColegioProcedencia> listarColegios() {
        return colegioProcedenciaRepository.findAll();
    }

    @Override
    public ColegioProcedencia obtenerColegioPorId(Long id) {
        return colegioProcedenciaRepository.findById(id).orElse(null);
    }
}
