package pe.cibertec.matricula.models.sincrud;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import pe.cibertec.matricula.models.ComprobantePago;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "responsable_caja")
public class ResponsableCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_responsable_caja;

    private String codigo;
    private String dni;
    private String nombres;
    private String apellidos;
    private String correo;

    // Relación OneToMany con ComprobantePago
    @OneToMany(mappedBy = "responsableCaja")
    @ToString.Exclude // Evitar bucles infinitos en toString
    private List<ComprobantePago> comprobantesPago;

    public String getNombres() {
        return nombres;
    }
}
