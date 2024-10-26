package pe.cibertec.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.matricula.models.ConstanciaReserva;

public interface ConstanciaReservaRepository extends JpaRepository<ConstanciaReserva, Long> {
    ConstanciaReserva findByCodigoConstanciaReserva(String codigoConstanciaReserva);
}
