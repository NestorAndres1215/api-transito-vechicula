package com.project.transito_vehiculos.controller;

import com.project.transito_vehiculos.model.Papeletas;
import com.project.transito_vehiculos.service.PapeletasService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/papeletas")
@RequiredArgsConstructor
@Tag(name = "Papeletas", description = "Gestión de papeletas de tránsito")
public class PapeletasController {

    private final PapeletasService service;

    @GetMapping
    @Operation(summary = "Listar todas las papeletas")
    public List<Papeletas> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una papeleta por ID")
    public Optional<Papeletas> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/vehiculo/{vehiculoId}")
    @Operation(summary = "Obtener papeletas de un vehículo")
    public List<Papeletas> getByVehiculo(@PathVariable Long vehiculoId) {
        return service.getByVehiculo(vehiculoId);
    }

    @GetMapping("/policia/{policiaId}")
    @Operation(summary = "Obtener papeletas emitidas por un policía")
    public List<Papeletas> getByPolicia(@PathVariable Long policiaId) {
        return service.getByPolicia(policiaId);
    }

    @GetMapping("/pagadas/{pagado}")
    @Operation(summary = "Obtener papeletas según estado de pago")
    public List<Papeletas> getByPagado(@PathVariable Boolean pagado) {
        return service.getByPagado(pagado);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva papeleta")
    public Papeletas create(@RequestBody Papeletas papeleta) {
        return service.save(papeleta);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una papeleta existente")
    public Papeletas update(@PathVariable Long id, @RequestBody Papeletas papeleta) {
        papeleta.setCodigo(id);
        return service.save(papeleta);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una papeleta")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
