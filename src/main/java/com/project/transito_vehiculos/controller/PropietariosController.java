package com.project.transito_vehiculos.controller;

import com.project.transito_vehiculos.model.Propietarios;
import com.project.transito_vehiculos.service.PropietariosService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/propietarios")
@RequiredArgsConstructor
@Tag(name = "Propietarios", description = "Gestión de propietarios de vehículos")
public class PropietariosController {

    private final PropietariosService service;

    @GetMapping
    @Operation(summary = "Listar todos los propietarios")
    public List<Propietarios> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un propietario por ID")
    public Optional<Propietarios> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo propietario")
    public Propietarios create(@RequestBody Propietarios propietario) {
        return service.save(propietario);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un propietario existente")
    public Propietarios update(@PathVariable Long id, @RequestBody Propietarios propietario) {
        propietario.setCodigo(id);
        return service.save(propietario);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un propietario")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
