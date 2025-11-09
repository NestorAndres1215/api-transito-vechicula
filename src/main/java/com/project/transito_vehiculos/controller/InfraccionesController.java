package com.project.transito_vehiculos.controller;

import com.project.transito_vehiculos.model.Infracciones;
import com.project.transito_vehiculos.service.InfraccionesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/infracciones")
@RequiredArgsConstructor
@Tag(name = "Infracciones", description = "Gestión de infracciones de tránsito")
public class InfraccionesController {

    private final InfraccionesService service;

    @GetMapping
    @Operation(summary = "Listar todas las infracciones")
    public ResponseEntity<List<Infracciones>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una infracción por ID")
    public ResponseEntity<Infracciones> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear una nueva infracción")
    public ResponseEntity<Infracciones> create(@Valid @RequestBody Infracciones infraccion) {
        return ResponseEntity.ok(service.save(infraccion));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una infracción existente")
    public ResponseEntity<Infracciones> update(
            @PathVariable Long id,
            @Valid @RequestBody Infracciones infraccionActualizada) {

        return service.getById(id)
                .map(infraccion -> {
                    infraccion.setDescripcion(infraccionActualizada.getDescripcion());
                    infraccion.setImporte(infraccionActualizada.getImporte());
                    infraccion.setEliminado(infraccionActualizada.getEliminado());
                    infraccion.setObservaciones(infraccionActualizada.getObservaciones());
                    Infracciones actualizada = service.save(infraccion);
                    return ResponseEntity.ok(actualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una infracción")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/fecha-desc")
    @Operation(summary = "Listar infracciones por fecha creación descendente")
    public ResponseEntity<List<Infracciones>> listarPorFechaDesc() {
        return ResponseEntity.ok(service.listarPorFechaDesc());
    }

    @GetMapping("/fecha-asc")
    @Operation(summary = "Listar infracciones por fecha creación ascendente")
    public ResponseEntity<List<Infracciones>> listarPorFechaAsc() {
        return ResponseEntity.ok(service.listarPorFechaAsc());
    }
}
