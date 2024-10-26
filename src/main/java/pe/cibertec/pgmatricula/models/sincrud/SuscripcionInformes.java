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
@Table(name = "suscripcion_informes")
public class SuscripcionInformes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_suscripcion_informes;

    private String correo;
    private String estado;

    // Relación ManyToOne con Alumno
    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    @ToString.Exclude // Evitar bucles infinitos en toString
    private Alumno alumno;
}
