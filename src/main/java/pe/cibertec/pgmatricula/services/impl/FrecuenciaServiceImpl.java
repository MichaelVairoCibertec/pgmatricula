package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.Frecuencia;
import pe.cibertec.matricula.repository.FrecuenciaRepository;
import pe.cibertec.matricula.services.FrecuenciaService;

import java.util.List;

@Service
public class FrecuenciaServiceImpl implements FrecuenciaService {

    @Autowired
    private FrecuenciaRepository frecuenciaRepository;

    @Override
    public List<Frecuencia> listarFrecuencias() {
        return frecuenciaRepository.findAll();
    }

    @Override
    public Frecuencia obtenerFrecuenciaPorId(Long id) {
        return frecuenciaRepository.findById(id).orElse(null);
    }

    @Override
    public Frecuencia guardarFrecuencia(Frecuencia frecuencia) {
        return frecuenciaRepository.save(frecuencia);
    }

    @Override
    public void eliminarFrecuencia(Long id) {
        frecuenciaRepository.deleteById(id);
    }
}
