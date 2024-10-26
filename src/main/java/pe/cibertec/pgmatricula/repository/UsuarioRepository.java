package pe.cibertec.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.matricula.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);  // Método para obtener usuario por nombre de usuario
}
