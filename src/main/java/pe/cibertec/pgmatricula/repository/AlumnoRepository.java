package pe.cibertec.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.matricula.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
