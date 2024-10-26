package pe.cibertec.matricula.repository.sincrud;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.matricula.models.sincrud.Tesorero;

public interface TesoreroRepository extends JpaRepository<Tesorero, Long> {
}
