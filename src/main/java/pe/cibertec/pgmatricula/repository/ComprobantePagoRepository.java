package pe.cibertec.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.matricula.models.ComprobantePago;

public interface ComprobantePagoRepository extends JpaRepository<ComprobantePago, Long> {
    ComprobantePago findByCodigoComprobante(String codigoComprobante);
}
