package com.microservicios.evaluacion.controller;

import com.microservicios.evaluacion.model.Evaluacion;
import com.microservicios.evaluacion.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {
    @Autowired
    private EvaluacionRepository repository;

    @PostMapping
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        if (evaluacion.getRut() == null || evaluacion.getRut().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        Evaluacion guardado = repository.save(evaluacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }


    @GetMapping
    public List<Evaluacion> listarEvaluaciones() {
        return repository.findAll();
    }

    @GetMapping("/{rut}")
    public Evaluacion obtenerEvaluacionPorRut(@PathVariable String rut) {  // Usa String
    return repository.findById(rut).orElse(null);  // Busca directamente por String
}
} 