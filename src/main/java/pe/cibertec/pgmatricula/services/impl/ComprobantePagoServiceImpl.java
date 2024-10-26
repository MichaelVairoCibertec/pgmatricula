package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.ComprobantePago;
import pe.cibertec.matricula.repository.ComprobantePagoRepository;
import pe.cibertec.matricula.services.ComprobantePagoService;

import java.util.List;

@Service
public class ComprobantePagoServiceImpl implements ComprobantePagoService {

    @Autowired
    private ComprobantePagoRepository comprobantePagoRepository;

    @Override
    public List<ComprobantePago> listarComprobantes() {
        return comprobantePagoRepository.findAll();
    }

    @Override
    public ComprobantePago obtenerComprobantePorId(Long id) {
        return comprobantePagoRepository.findById(id).orElse(null);
    }

    @Override
    public ComprobantePago guardarComprobante(ComprobantePago comprobantePago) {
        return comprobantePagoRepository.save(comprobantePago);
    }

    @Override
    public void eliminarComprobante(Long id) {
        comprobantePagoRepository.deleteById(id);
    }

    @Override
    public ComprobantePago obtenerComprobantePorCodigo(String codigo) {
        return comprobantePagoRepository.findByCodigoComprobante(codigo);
    }
}
