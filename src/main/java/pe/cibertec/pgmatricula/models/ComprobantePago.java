package pe.cibertec.matricula.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import pe.cibertec.matricula.models.sincrud.ResponsableCaja;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comprobante_pago")
public class ComprobantePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_comprobante_pago;

    @Column(name = "codigo_comprobante")
    private String codigoComprobante;

    private Double monto_pagado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_pago;

    private String metodo_pago;

    // Relación con Alumno
    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    // Relación con Responsable Caja
    @ManyToOne
    @JoinColumn(name = "id_responsable_caja", nullable = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ResponsableCaja responsableCaja;

    public String getCodigoComprobante() {
        return codigoComprobante;
    }

    public Double getMonto_pagado() {
        return monto_pagado;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public ResponsableCaja getResponsableCaja() {
        return responsableCaja;
    }
}
