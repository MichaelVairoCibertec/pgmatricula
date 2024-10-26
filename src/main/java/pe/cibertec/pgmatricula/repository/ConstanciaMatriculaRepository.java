package pe.cibertec.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.matricula.models.ConstanciaMatricula;

public interface ConstanciaMatriculaRepository extends JpaRepository<ConstanciaMatricula, Long> {
    ConstanciaMatricula findByCodigoConstanciaMatricula(String codigoConstanciaMatricula);
}
