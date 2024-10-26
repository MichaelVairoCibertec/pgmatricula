package pe.cibertec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.matricula.models.Usuario;
import pe.cibertec.matricula.services.UsuarioService;
import jakarta.servlet.http.HttpSession;  // Ajuste a Jakarta

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String mostrarFormularioLogin() {
        return "login";  // Muestra la página de inicio de sesión
    }

    @PostMapping
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, Model model) {

        Usuario usuario = usuarioService.obtenerPorUsername(username);

        if (usuario != null && usuario.getPassword().equals(password)) {
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/";  // Redirige al index después de iniciar sesión
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";  // Muestra el mensaje de error si las credenciales son incorrectas
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Invalida la sesión actual
        return "redirect:/login";  // Redirige al login después de cerrar sesión
    }
}
