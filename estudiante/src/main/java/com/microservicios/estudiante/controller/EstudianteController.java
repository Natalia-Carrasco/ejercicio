package com.microservicios.estudiante.controller;

import com.microservicios.estudiante.model.Estudiante;
import com.microservicios.estudiante.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteRepository.save(estudiante));
    }

    @GetMapping
    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }

    @GetMapping("/{rut}")
    public ResponseEntity<Estudiante> obtenerPorRut(@PathVariable String rut) {
        return estudianteRepository.findById(rut)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}