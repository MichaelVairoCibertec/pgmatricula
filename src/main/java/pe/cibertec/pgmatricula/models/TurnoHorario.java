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
@Table(name = "turno_horario")
public class TurnoHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turno_horario;

    private String turno;
    private String horario_inicio;
    private String horario_fin;

    // Relación con Alumno (OneToMany)
    @OneToMany(mappedBy = "turnoHorario")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Alumno> alumnos;

    // Relación con Postulante (OneToMany)
    @OneToMany(mappedBy = "turnoHorario")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Postulante> postulantes;

    // Relación con Frecuencia (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "id_frecuencia", nullable = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Frecuencia frecuencia;
}
