package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.Vacante;
import pe.cibertec.matricula.repository.VacanteRepository;
import pe.cibertec.matricula.services.VacanteService;

import java.util.List;

@Service
public class VacanteServiceImpl implements VacanteService {

    @Autowired
    private VacanteRepository vacanteRepository;

    @Override
    public List<Vacante> listarVacantes() {
        return vacanteRepository.findAll();
    }

    @Override
    public Vacante obtenerVacantePorId(Long id) {
        return vacanteRepository.findById(id).orElse(null);
    }

    @Override
    public Vacante guardarVacante(Vacante vacante) {
        return vacanteRepository.save(vacante);
    }

    @Override
    public void eliminarVacante(Long id) {
        vacanteRepository.deleteById(id);
    }
}
