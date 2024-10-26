package pe.cibertec.matricula.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import pe.cibertec.matricula.models.sincrud.ColegioProcedencia;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "postulante")
public class Postulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_postulante;

    private String apellido_paterno;
    private String apellido_materno;
    private String nombres;
    private String genero;
    private String tipo_documento;
    private String numero_documento;
    private String discapacidad;

    // Relación con Turno Horario
    @ManyToOne
    @JoinColumn(name = "id_turno_horario", nullable = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private TurnoHorario turnoHorario;

    // Relación con Familiar Apoderado
    @ManyToOne
    @JoinColumn(name = "id_familiar_apoderado", nullable = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private FamiliarApoderado familiarApoderado;

    // Relación con Colegio Procedencia
    @ManyToOne
    @JoinColumn(name = "id_colegio_procedencia", nullable = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ColegioProcedencia colegioProcedencia;
}
