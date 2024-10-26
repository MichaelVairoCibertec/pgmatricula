package pe.cibertec.matricula.models.sincrud;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import pe.cibertec.matricula.models.Alumno;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "solicitud_constancia_reserva")
public class SolicitudConstanciaReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_solicitud_reserva;

    private String codigo_solicitud;
    private String estado;
    private String observaciones;

    // Relación ManyToOne con Alumno
    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    @ToString.Exclude // Evitar bucles infinitos en toString
    private Alumno alumno;
}
