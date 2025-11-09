package com.project.transito_vehiculos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "modelo", nullable = false, length = 100)
    @NotBlank(message = "El modelo es obligatorio")
    private String modelo;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "anio", nullable = false)
    @Min(value = 1900, message = "El año debe ser mayor o igual a 1900")
    @Max(value = 2100, message = "El año debe ser menor o igual a 2100")
    private Integer anio;

    @Column(name = "placa", nullable = false, unique = true, length = 15)
    @NotBlank(message = "La placa es obligatoria")
    private String placa;

    @Column(name = "observaciones", length = 250)
    private String observaciones;

    @Column(name = "tipo", length = 50)
    private String tipo; // Ej: Auto, Moto, Camioneta

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "propietario_id", nullable = false)
    private Propietarios propietario;

    @Column(name = "eliminado", length = 2)
    @NotBlank(message = "El campo eliminado no puede estar vacío")
    @Pattern(regexp = "No|Si", message = "El campo eliminado solo puede ser 'No' o 'Si'")
    private String eliminado;
}
