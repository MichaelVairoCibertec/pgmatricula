package pe.cibertec.matricula.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "frecuencia")
public class Frecuencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_frecuencia;

    private String dias;
    private String tipo;
    private String descripcion;

    // Relación con Alumno
    @OneToMany(mappedBy = "frecuencia")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Alumno> alumnos;

    // Relación con Turno Horario
    @OneToMany(mappedBy = "frecuencia")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<TurnoHorario> turnosHorario;
}
