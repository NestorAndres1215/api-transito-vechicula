package com.project.transito_vehiculos.repository;

import com.project.transito_vehiculos.model.Infracciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfraccionesRepository extends JpaRepository<Infracciones, Long> {
    List<Infracciones> findAllByOrderByFechaCreacionDesc();

    List<Infracciones> findAllByOrderByFechaCreacionAsc();
}
