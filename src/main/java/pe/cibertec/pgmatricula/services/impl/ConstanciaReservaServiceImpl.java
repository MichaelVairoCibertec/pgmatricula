package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.ConstanciaReserva;
import pe.cibertec.matricula.repository.ConstanciaReservaRepository;
import pe.cibertec.matricula.services.ConstanciaReservaService;

import java.util.List;

@Service
public class ConstanciaReservaServiceImpl implements ConstanciaReservaService {

    @Autowired
    private ConstanciaReservaRepository constanciaReservaRepository;

    @Override
    public List<ConstanciaReserva> listarConstancias() {
        return constanciaReservaRepository.findAll();
    }

    @Override
    public ConstanciaReserva obtenerConstanciaPorId(Long id) {
        return constanciaReservaRepository.findById(id).orElse(null);
    }

    @Override
    public ConstanciaReserva guardarConstancia(ConstanciaReserva constanciaReserva) {
        return constanciaReservaRepository.save(constanciaReserva);
    }

    @Override
    public void eliminarConstancia(Long id) {
        constanciaReservaRepository.deleteById(id);
    }

    @Override
    public ConstanciaReserva obtenerConstanciaPorCodigo(String codigo) {
        return constanciaReservaRepository.findByCodigoConstanciaReserva(codigo);
    }
}
