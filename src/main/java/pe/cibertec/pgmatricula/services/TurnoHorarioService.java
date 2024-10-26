package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.TurnoHorario;
import java.util.List;

public interface TurnoHorarioService {
    List<TurnoHorario> listarTurnos();
    TurnoHorario obtenerTurnoPorId(Long id);
    TurnoHorario guardarTurno(TurnoHorario turnoHorario);
    void eliminarTurno(Long id);
}
