package com.project.transito_vehiculos.repository;

import com.project.transito_vehiculos.model.Policias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliciasRepository extends JpaRepository<Policias, Long> {
    // Ejemplo: buscar por número de placa interno
    boolean existsByNumero(String numero);
}
