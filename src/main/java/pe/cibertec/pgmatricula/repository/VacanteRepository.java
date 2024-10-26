package pe.cibertec.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.matricula.models.Vacante;

public interface VacanteRepository extends JpaRepository<Vacante, Long> {
}
