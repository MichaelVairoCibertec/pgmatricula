package pe.cibertec.matricula.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import pe.cibertec.matricula.models.sincrud.SecretariaAcademica;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "constancia_reserva")
public class ConstanciaReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_constancia_reserva;

    @Column(name = "codigo_constancia_reserva")
    private String codigoConstanciaReserva;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_emision;

    // Relación con Alumno
    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Alumno alumno;

    // Relación con Secretaría Académica
    @ManyToOne
    @JoinColumn(name = "id_secretaria_academica", nullable = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private SecretariaAcademica secretariaAcademica;

    public String getCodigo_constancia_reserva() {
        return codigoConstanciaReserva;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public SecretariaAcademica getSecretariaAcademica() {
        return secretariaAcademica;
    }
}
