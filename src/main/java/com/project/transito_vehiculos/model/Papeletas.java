package com.project.transito_vehiculos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "papeletas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Papeletas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "policia_id", nullable = false)
    private Policias policia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "infraccion_id", nullable = false)
    private Infracciones infraccion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculos vehiculo;

    @Column(name = "fecha_papeleta", nullable = false)
    private LocalDate fechaPapeleta;

    @Column(name = "pagado")
    private Boolean pagado = false;

    @Column(name = "fecha_pago")
    private LocalDate fechaPago;

    @Column(name = "eliminado", length = 2)
    @NotBlank(message = "El campo eliminado no puede estar vacío")
    @Pattern(regexp = "No|Si", message = "El campo eliminado solo puede ser 'No' o 'Si'")
    private String eliminado;

    @Column(name = "lugar", length = 200)
    private String lugar;

    @Column(name = "observaciones", length = 250)
    private String observaciones;
}
