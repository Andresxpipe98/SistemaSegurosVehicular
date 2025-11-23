package com.SSV.SistemaSegurosVehicular.repository;

import com.SSV.SistemaSegurosVehicular.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

}
