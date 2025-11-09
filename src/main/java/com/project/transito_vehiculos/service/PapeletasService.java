package com.project.transito_vehiculos.service;
import com.project.transito_vehiculos.model.Papeletas;
import com.project.transito_vehiculos.repository.PapeletasRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PapeletasService {

    private final PapeletasRepository repository;


    public List<Papeletas> getAll() {
        return repository.findAll();
    }

    public Optional<Papeletas> getById(Long id) {
        return repository.findById(id);
    }


    public Papeletas save(Papeletas papeleta) {
        return repository.save(papeleta);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public List<Papeletas> getByVehiculo(Long vehiculoId) {
        return repository.findByVehiculoCodigo(vehiculoId);
    }

    public List<Papeletas> getByPolicia(Long policiaId) {
        return repository.findByPoliciaCodigo(policiaId);
    }


    public List<Papeletas> getByPagado(Boolean pagado) {
        return repository.findByPagado(pagado);
    }
}
