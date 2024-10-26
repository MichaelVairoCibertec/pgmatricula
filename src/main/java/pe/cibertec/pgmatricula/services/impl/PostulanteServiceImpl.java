package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.Postulante;
import pe.cibertec.matricula.repository.PostulanteRepository;
import pe.cibertec.matricula.services.PostulanteService;

import java.util.List;

@Service
public class PostulanteServiceImpl implements PostulanteService {

    @Autowired
    private PostulanteRepository postulanteRepository;

    @Override
    public List<Postulante> listarPostulantes() {
        return postulanteRepository.findAll();
    }

    @Override
    public Postulante obtenerPostulantePorId(Long id) {
        return postulanteRepository.findById(id).orElse(null);
    }

    @Override
    public Postulante guardarPostulante(Postulante postulante) {
        return postulanteRepository.save(postulante);
    }

    @Override
    public void eliminarPostulante(Long id) {
        postulanteRepository.deleteById(id);
    }
}
