package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.sincrud.ResponsableCaja;
import pe.cibertec.matricula.repository.sincrud.ResponsableCajaRepository;
import pe.cibertec.matricula.services.ResponsableCajaService;

import java.util.List;

@Service
public class ResponsableCajaServiceImpl implements ResponsableCajaService {

    @Autowired
    private ResponsableCajaRepository responsableCajaRepository;

    @Override
    public List<ResponsableCaja> listarResponsablesCaja() {
        return responsableCajaRepository.findAll();
    }
}
