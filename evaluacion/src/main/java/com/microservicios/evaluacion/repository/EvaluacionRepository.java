package com.microservicios.evaluacion.repository;

import com.microservicios.evaluacion.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluacionRepository extends JpaRepository <Evaluacion, String> {
    List<Evaluacion> findByRut(String rut);
}