package pe.cibertec.matricula.models;

import jakarta.persistence.*;
import lombok.*;
import pe.cibertec.matricula.models.sincrud.Tesorero;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orden_pago")
public class OrdenPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden_pago;

    @Column(name = "nro_orden")
    private String nroOrden;

    private Date fecha_emision;
    private Double monto_total;
    private Date fecha_vencimiento;
    private String observaciones;

    // Relación con Alumno
    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Alumno alumno;

    // Relación con Tesorero
    @ManyToOne
    @JoinColumn(name = "id_tesorero", nullable = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Tesorero tesorero;

    // Getters manuales
    public String getNro_orden() {
        return nroOrden;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public Double getMonto_total() {
        return monto_total;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Tesorero getTesorero() {
        return tesorero;
    }
}
