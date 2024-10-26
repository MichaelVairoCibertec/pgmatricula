package pe.cibertec.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.matricula.models.TurnoHorario;

public interface TurnoHorarioRepository extends JpaRepository<TurnoHorario, Long> {
}
