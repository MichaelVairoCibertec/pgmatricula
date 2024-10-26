package pe.cibertec.matricula.models.sincrud;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import pe.cibertec.matricula.models.Alumno;
import pe.cibertec.matricula.models.Postulante;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "colegio_procedencia")
public class ColegioProcedencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_colegio_procedencia;

    private String nombre_colegio;
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;

    // Relación OneToMany con Alumno
    @OneToMany(mappedBy = "colegioProcedencia")
    @ToString.Exclude // Evitar bucles infinitos en toString
    private List<Alumno> alumnos;

    // Relación OneToMany con Postulante
    @OneToMany(mappedBy = "colegioProcedencia")
    @ToString.Exclude // Evitar bucles infinitos en toString
    private List<Postulante> postulantes;
}
