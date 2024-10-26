package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.Usuario;

public interface UsuarioService {
    Usuario obtenerPorUsername(String username);
}
