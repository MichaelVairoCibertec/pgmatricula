package pe.cibertec.matricula.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vacante")
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vacante;

    private String codigo_vacante;
    private Integer cantidad;
    private String descripcion;

    // Relación con Alumno
    @OneToMany(mappedBy = "vacante")
    @ToString.Exclude // Evitar bucles infinitos en toString
    private List<Alumno> alumnos;
}
