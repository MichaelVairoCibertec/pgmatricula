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
@Table(name = "familiar_apoderado")
public class FamiliarApoderado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_familiar_apoderado;

    private String apellido_paterno;
    private String apellido_materno;
    private String nombres;
    private String tipo_documento;
    private String numero_documento;
    private String parentesco;
    private String ocupacion;
    private String telefono_fijo;
    private String telefono_celular;
    private String correo_electronico;

    // Relación con Alumno (OneToMany)
    @OneToMany(mappedBy = "familiarApoderado")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Alumno> alumnos;

    // Relación con Postulante (OneToMany)
    @OneToMany(mappedBy = "familiarApoderado")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Postulante> postulantes;
}
