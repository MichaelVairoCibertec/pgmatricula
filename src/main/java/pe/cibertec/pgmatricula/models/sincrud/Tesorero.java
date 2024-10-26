package pe.cibertec.matricula.models.sincrud;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import pe.cibertec.matricula.models.OrdenPago;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tesorero")
public class Tesorero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tesorero;

    private String nombre;
    private String apellido;
    private String dni;
    private String correo;

    // Relación OneToMany con OrdenPago
    @OneToMany(mappedBy = "tesorero")
    @ToString.Exclude // Evitar bucles en toString
    private List<OrdenPago> ordenesPago;

    // Getters manuales
    public String getNombre() {
        return nombre;
    }
}
