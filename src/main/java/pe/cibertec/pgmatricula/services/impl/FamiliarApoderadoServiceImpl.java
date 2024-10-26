package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.FamiliarApoderado;
import pe.cibertec.matricula.repository.FamiliarApoderadoRepository;
import pe.cibertec.matricula.services.FamiliarApoderadoService;

import java.util.List;

@Service
public class FamiliarApoderadoServiceImpl implements FamiliarApoderadoService {

    @Autowired
    private FamiliarApoderadoRepository familiarRepository;

    @Override
    public List<FamiliarApoderado> listarFamiliares() {
        return familiarRepository.findAll();
    }

    @Override
    public FamiliarApoderado obtenerFamiliarPorId(Long id) {
        return familiarRepository.findById(id).orElse(null);
    }

    @Override
    public FamiliarApoderado guardarFamiliar(FamiliarApoderado familiar) {
        return familiarRepository.save(familiar);
    }

    @Override
    public void eliminarFamiliar(Long id) {
        familiarRepository.deleteById(id);
    }
}
