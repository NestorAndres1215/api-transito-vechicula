package com.project.transito_vehiculos.controller;

import com.project.transito_vehiculos.model.Vehiculos;
import com.project.transito_vehiculos.service.VehiculosService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
@Tag(name = "Vehiculos", description = "Gestión de vehículos")
public class VehiculosController {

    private final VehiculosService service;

    @GetMapping
    @Operation(summary = "Listar todos los vehículos")
    public List<Vehiculos> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un vehículo por ID")
    public Optional<Vehiculos> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/propietario/{propietarioId}")
    @Operation(summary = "Obtener vehículos de un propietario")
    public List<Vehiculos> getByPropietario(@PathVariable Long propietarioId) {
        return service.getByPropietario(propietarioId);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo vehículo")
    public Vehiculos create(@RequestBody Vehiculos vehiculo) {
        return service.save(vehiculo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un vehículo existente")
    public Vehiculos update(@PathVariable Long id, @RequestBody Vehiculos vehiculo) {
        vehiculo.setCodigo(id);
        return service.save(vehiculo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un vehículo")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
