package com.project.transito_vehiculos.service;
import com.project.transito_vehiculos.model.Vehiculos;
import com.project.transito_vehiculos.repository.VehiculosRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculosService {

    private final VehiculosRepository repository;


    public List<Vehiculos> getAll() {
        return repository.findAll();
    }

    public Optional<Vehiculos> getById(Long id) {
        return repository.findById(id);
    }

    public Vehiculos save(Vehiculos vehiculo) {
        return repository.save(vehiculo);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public List<Vehiculos> getByPropietario(Long propietarioId) {
        return repository.findByPropietarioCodigo(propietarioId);
    }
}
