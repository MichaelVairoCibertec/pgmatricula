package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.OrdenPago;
import pe.cibertec.matricula.repository.OrdenPagoRepository;
import pe.cibertec.matricula.services.OrdenPagoService;

import java.util.List;

@Service
public class OrdenPagoServiceImpl implements OrdenPagoService {

    @Autowired
    private OrdenPagoRepository ordenPagoRepository;

    @Override
    public List<OrdenPago> listarOrdenes() {
        return ordenPagoRepository.findAll();
    }

    @Override
    public OrdenPago obtenerOrdenPorId(Long id) {
        return ordenPagoRepository.findById(id).orElse(null);
    }

    @Override
    public OrdenPago guardarOrden(OrdenPago ordenPago) {
        return ordenPagoRepository.save(ordenPago);
    }

    @Override
    public void eliminarOrden(Long id) {
        ordenPagoRepository.deleteById(id);
    }

    @Override
    public OrdenPago obtenerOrdenPorCodigo(String codigo) {
        return ordenPagoRepository.findByNroOrden(codigo);
    }
}
