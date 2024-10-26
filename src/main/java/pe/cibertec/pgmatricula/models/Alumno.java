package pe.cibertec.matricula.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import pe.cibertec.matricula.models.sincrud.ColegioProcedencia;
import pe.cibertec.matricula.models.sincrud.SolicitudConstanciaReserva;
import pe.cibertec.matricula.models.sincrud.SuscripcionInformes;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alumno;

    private String dni;
    private String nombre;
    private String apellido;
    private String sexo;
    private String fecha_nacimiento;
    private Integer edad;
    private String direccion;

    // Relación con Frecuencia
    @ManyToOne
    @JoinColumn(name = "id_frecuencia", nullable = false)
    private Frecuencia frecuencia;

    // Relación con Vacante
    @ManyToOne
    @JoinColumn(name = "id_vacante", nullable = true)
    private Vacante vacante;

    // Relación con Colegio Procedencia
    @ManyToOne
    @JoinColumn(name = "id_colegio_procedencia", nullable = true)
    private ColegioProcedencia colegioProcedencia;

    // Relación con Familiar Apoderado
    @ManyToOne
    @JoinColumn(name = "id_familiar_apoderado", nullable = true)
    private FamiliarApoderado familiarApoderado;

    // Relación con Turno Horario
    @ManyToOne
    @JoinColumn(name = "id_turno_horario", nullable = true)
    private TurnoHorario turnoHorario;

    // Relación con Ordenes de Pago
    @OneToMany(mappedBy = "alumno")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<OrdenPago> ordenesPago;

    // Relación con Comprobantes de Pago
    @OneToMany(mappedBy = "alumno")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ComprobantePago> comprobantesPago;

    // Relación con Constancias de Matrícula
    @OneToMany(mappedBy = "alumno")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ConstanciaMatricula> constanciasMatricula;

    // Relación con Constancias de Reserva
    @OneToMany(mappedBy = "alumno")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ConstanciaReserva> constanciasReserva;

    // Relación con Solicitud Constancia Reserva
    @OneToMany(mappedBy = "alumno")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<SolicitudConstanciaReserva> solicitudesReserva;

    // Relación con Suscripciones a Informes
    @OneToMany(mappedBy = "alumno")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<SuscripcionInformes> suscripcionesInformes;

    // Getters manuales
    public String getNombre() {
        return nombre;
    }
}
