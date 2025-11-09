package com.project.transito_vehiculos.repository;

import com.project.transito_vehiculos.model.Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehiculosRepository extends JpaRepository<Vehiculos, Long> {
    // Buscar todos los vehículos de un propietario
    List<Vehiculos> findByPropietarioCodigo(Long propietarioCodigo);

    // Buscar por placa
    boolean existsByPlaca(String placa);
}
