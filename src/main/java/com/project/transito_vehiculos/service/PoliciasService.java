package com.project.transito_vehiculos.service;

import com.project.transito_vehiculos.model.Policias;
import com.project.transito_vehiculos.repository.PoliciasRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PoliciasService {

    private final PoliciasRepository repository;

    public List<Policias> getAll() {
        return repository.findAll();
    }


    public Optional<Policias> getById(Long id) {
        return repository.findById(id);
    }


    public Policias save(Policias policia) {
        return repository.save(policia);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}
