package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.TurnoHorario;
import pe.cibertec.matricula.repository.TurnoHorarioRepository;
import pe.cibertec.matricula.services.TurnoHorarioService;

import java.util.List;

@Service
public class TurnoHorarioServiceImpl implements TurnoHorarioService {

    @Autowired
    private TurnoHorarioRepository turnoHorarioRepository;

    @Override
    public List<TurnoHorario> listarTurnos() {
        return turnoHorarioRepository.findAll();
    }

    @Override
    public TurnoHorario obtenerTurnoPorId(Long id) {
        return turnoHorarioRepository.findById(id).orElse(null);
    }

    @Override
    public TurnoHorario guardarTurno(TurnoHorario turnoHorario) {
        return turnoHorarioRepository.save(turnoHorario);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoHorarioRepository.deleteById(id);
    }
}
