package pe.cibertec.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.matricula.models.OrdenPago;

public interface OrdenPagoRepository extends JpaRepository<OrdenPago, Long> {
    OrdenPago findByNroOrden(String nroOrden);
}
