package com.cibertec.daw1.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.daw1.dtos.EmpleadoDTO;
import com.cibertec.daw1.services.IEmpleadoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    private final IEmpleadoService empleadoService;

    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> listarEmpleados() {
        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> buscarEmpleado(@PathVariable Integer id) {
        return ResponseEntity.ok(empleadoService.buscarEmpleado(id));
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> registrarEmpleado(@Valid @RequestBody EmpleadoDTO dto) {
        EmpleadoDTO creado = empleadoService.registrarEmpleado(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(
            @PathVariable Integer id,
            @Valid @RequestBody EmpleadoDTO dto) {
        return ResponseEntity.ok(empleadoService.actualizarEmpleado(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Integer id) {
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}