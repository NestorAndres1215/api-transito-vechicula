package com.project.transito_vehiculos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;

@Entity
@Table(name = "infracciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Infracciones {

    @Id
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "descripcion", length = 200)
    @NotBlank(message = "La descripción de la infracción es obligatoria")
    @Size(max = 50, message = "La descripción no puede exceder 50 caracteres")
    private String descripcion;

    @Column(name = "importe")
    @NotNull(message = "El importe es obligatorio")
    private Double importe;

    @Column(name = "eliminado", length = 2)
    @NotBlank(message = "El campo eliminado no puede estar vacío")
    @Pattern(regexp = "No|Si", message = "El campo eliminado solo puede ser 'No' o 'Si'")
    private String eliminado;

    @Column(name = "observaciones", length = 250)
    private String observaciones;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;
}
