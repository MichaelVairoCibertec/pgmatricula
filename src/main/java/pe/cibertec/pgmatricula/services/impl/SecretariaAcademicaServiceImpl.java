package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.sincrud.SecretariaAcademica;
import pe.cibertec.matricula.repository.sincrud.SecretariaAcademicaRepository;
import pe.cibertec.matricula.services.SecretariaAcademicaService;

import java.util.List;

@Service
public class SecretariaAcademicaServiceImpl implements SecretariaAcademicaService {

    @Autowired
    private SecretariaAcademicaRepository secretariaAcademicaRepository;

    @Override
    public List<SecretariaAcademica> listarSecretarias() {
        return secretariaAcademicaRepository.findAll();
    }

    @Override
    public SecretariaAcademica obtenerSecretariaPorId(Long id) {
        return secretariaAcademicaRepository.findById(id).orElse(null);
    }

    @Override
    public SecretariaAcademica guardarSecretaria(SecretariaAcademica secretariaAcademica) {
        return secretariaAcademicaRepository.save(secretariaAcademica);
    }

    @Override
    public void eliminarSecretaria(Long id) {
        secretariaAcademicaRepository.deleteById(id);
    }
}
