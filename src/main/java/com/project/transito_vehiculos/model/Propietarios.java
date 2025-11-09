package com.project.transito_vehiculos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "propietarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Propietarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "dni", nullable = false, unique = true, length = 12)
    @NotBlank(message = "El DNI es obligatorio")
    private String dni;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "eliminado", length = 2)
    @NotBlank(message = "El campo eliminado no puede estar vacío")
    @Pattern(regexp = "No|Si", message = "El campo eliminado solo puede ser 'No' o 'Si'")
    private String eliminado;
}
