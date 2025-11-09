package com.project.transito_vehiculos.service;

import com.project.transito_vehiculos.model.Infracciones;
import com.project.transito_vehiculos.repository.InfraccionesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InfraccionesService {

    private final InfraccionesRepository repository;

    public List<Infracciones> getAll() {
        return repository.findAll();
    }

    public Optional<Infracciones> getById(Long id) {
        return repository.findById(id);
    }

    public Infracciones save(Infracciones infraccion) {
        return repository.save(infraccion);
    }

    public List<Infracciones> listarPorFechaDesc() {
        return repository.findAllByOrderByFechaCreacionDesc();
    }


    public List<Infracciones> listarPorFechaAsc() {
        return repository.findAllByOrderByFechaCreacionAsc();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
