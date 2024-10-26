package pe.cibertec.matricula.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pe.cibertec.matricula.interceptors.SessionInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor)
                .excludePathPatterns("/login", "/login/**", "/css/**", "/js/**", "/img/**", "/images/**");  // Excluye las rutas de login y recursos estáticos
    }
}
