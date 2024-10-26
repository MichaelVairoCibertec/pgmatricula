package pe.cibertec.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.matricula.models.Postulante;

public interface PostulanteRepository extends JpaRepository<Postulante, Long> {
}
