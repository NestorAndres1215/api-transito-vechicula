package com.project.transito_vehiculos.repository;

import com.project.transito_vehiculos.model.Papeletas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PapeletasRepository extends JpaRepository<Papeletas, Long> {
    // Buscar papeletas por vehículo
    List<Papeletas> findByVehiculoCodigo(Long vehiculoCodigo);

    // Buscar papeletas pagadas o no
    List<Papeletas> findByPagado(Boolean pagado);

    // Buscar papeletas por policía
    List<Papeletas> findByPoliciaCodigo(Long policiaCodigo);


}
