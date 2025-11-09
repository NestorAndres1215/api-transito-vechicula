package com.project.transito_vehiculos.repository;

import com.project.transito_vehiculos.model.Propietarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietariosRepository extends JpaRepository<Propietarios, Long> {
    // Ejemplo: buscar por DNI
    boolean existsByDni(String dni);
}
