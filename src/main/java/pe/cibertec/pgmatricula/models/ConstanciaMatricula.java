package pe.cibertec.matricula.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "constancia_matricula")
public class ConstanciaMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_constancia_matricula;

    @Column(name = "codigo_constancia_matricula")
    private String codigoConstanciaMatricula;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_emision;

    // Relación con Alumno
    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Alumno alumno;

    public String getCodigo_constancia_matricula() {
        return codigoConstanciaMatricula;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public Alumno getAlumno() {
        return alumno;
    }
}
