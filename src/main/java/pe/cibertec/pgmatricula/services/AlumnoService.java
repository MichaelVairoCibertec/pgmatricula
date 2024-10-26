package pe.cibertec.matricula.services;

import pe.cibertec.matricula.models.Alumno;
import java.util.List;

public interface AlumnoService {
    List<Alumno> listarAlumnos();
    Alumno obtenerAlumnoPorId(Long id);
    Alumno guardarAlumno(Alumno alumno);
    void eliminarAlumno(Long id);
}
