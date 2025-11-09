package com.project.transito_vehiculos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "policias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Policias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Column(name = "numero", nullable = false, unique = true, length = 20)
    @NotBlank(message = "El número del policía es obligatorio")
    private String numero; // número de placa o código interno

    @Column(name = "dni", nullable = false, unique = true, length = 12)
    @NotBlank(message = "El DNI es obligatorio")
    private String dni;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "correo", length = 100)
    @Email(message = "El correo debe ser válido")
    private String correo;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Column(name = "eliminado", length = 2)
    @NotBlank(message = "El campo eliminado no puede estar vacío")
    @Pattern(regexp = "No|Si", message = "El campo eliminado solo puede ser 'No' o 'Si'")
    private String eliminado;


}
