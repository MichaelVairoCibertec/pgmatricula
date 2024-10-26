package pe.cibertec.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.matricula.models.Frecuencia;

public interface FrecuenciaRepository extends JpaRepository<Frecuencia, Long> {
}
