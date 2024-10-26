package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.sincrud.Tesorero;
import pe.cibertec.matricula.repository.sincrud.TesoreroRepository;
import pe.cibertec.matricula.services.TesoreroService;

import java.util.List;

@Service
public class TesoreroServiceImpl implements TesoreroService {

    @Autowired
    private TesoreroRepository tesoreroRepository;

    @Override
    public List<Tesorero> listarTesoreros() {
        return tesoreroRepository.findAll();
    }

    @Override
    public Tesorero obtenerTesoreroPorId(Long id) {
        return tesoreroRepository.findById(id).orElse(null);
    }

    @Override
    public Tesorero guardarTesorero(Tesorero tesorero) {
        return tesoreroRepository.save(tesorero);
    }

    @Override
    public void eliminarTesorero(Long id) {
        tesoreroRepository.deleteById(id);
    }
}
