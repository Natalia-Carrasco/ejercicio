package com.microservicios.estudiante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservicios.estudiante.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, String>{
    
}
