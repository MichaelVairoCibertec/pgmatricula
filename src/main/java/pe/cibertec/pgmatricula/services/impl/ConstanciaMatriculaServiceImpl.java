package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.ConstanciaMatricula;
import pe.cibertec.matricula.repository.ConstanciaMatriculaRepository;
import pe.cibertec.matricula.services.ConstanciaMatriculaService;

import java.util.List;

@Service
public class ConstanciaMatriculaServiceImpl implements ConstanciaMatriculaService {

    @Autowired
    private ConstanciaMatriculaRepository constanciaMatriculaRepository;

    @Override
    public List<ConstanciaMatricula> listarConstancias() {
        return constanciaMatriculaRepository.findAll();
    }

    @Override
    public ConstanciaMatricula obtenerConstanciaPorId(Long id) {
        return constanciaMatriculaRepository.findById(id).orElse(null);
    }

    @Override
    public ConstanciaMatricula guardarConstancia(ConstanciaMatricula constanciaMatricula) {
        return constanciaMatriculaRepository.save(constanciaMatricula);
    }

    @Override
    public void eliminarConstancia(Long id) {
        constanciaMatriculaRepository.deleteById(id);
    }

    @Override
    public ConstanciaMatricula obtenerConstanciaPorCodigo(String codigo) {
        return constanciaMatriculaRepository.findByCodigoConstanciaMatricula(codigo);
    }
}
