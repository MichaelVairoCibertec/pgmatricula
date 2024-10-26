package pe.cibertec.matricula.models.sincrud;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import pe.cibertec.matricula.models.ConstanciaReserva;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "secretaria_academica")
public class SecretariaAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_secretaria_academica;

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;

    // Relación OneToMany con ConstanciaReserva
    @OneToMany(mappedBy = "secretariaAcademica")
    @ToString.Exclude // Evitar bucles infinitos en toString
    private List<ConstanciaReserva> constanciasReserva;

    public String getNombre() {
        return nombre;
    }
}
