package com.project.transito_vehiculos.controller;

import com.project.transito_vehiculos.model.Policias;
import com.project.transito_vehiculos.service.PoliciasService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/policias")
@RequiredArgsConstructor
@Tag(name = "Policias", description = "Gestión de policías")
public class PoliciasController {

    private final PoliciasService service;

    @GetMapping
    @Operation(summary = "Listar todos los policías")
    public List<Policias> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un policía por ID")
    public Optional<Policias> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo policía")
    public Policias create(@RequestBody Policias policia) {
        return service.save(policia);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un policía existente")
    public Policias update(@PathVariable Long id, @RequestBody Policias policia) {
        policia.setCodigo(id);
        return service.save(policia);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un policía")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
