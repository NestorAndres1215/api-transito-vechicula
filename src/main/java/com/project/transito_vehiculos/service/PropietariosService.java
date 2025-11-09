package com.project.transito_vehiculos.service;

import com.project.transito_vehiculos.model.Propietarios;
import com.project.transito_vehiculos.repository.PropietariosRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropietariosService {

    private final PropietariosRepository repository;

    public List<Propietarios> getAll() {
        return repository.findAll();
    }


    public Optional<Propietarios> getById(Long id) {
        return repository.findById(id);
    }


    public Propietarios save(Propietarios propietario) {
        return repository.save(propietario);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}
