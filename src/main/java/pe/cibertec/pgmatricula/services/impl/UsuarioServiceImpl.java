package pe.cibertec.matricula.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.matricula.models.Usuario;
import pe.cibertec.matricula.repository.UsuarioRepository;
import pe.cibertec.matricula.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerPorUsername(String username) {
        return usuarioRepository.findByUsername(username);  // Ajusta el nombre de la tabla
    }
}
