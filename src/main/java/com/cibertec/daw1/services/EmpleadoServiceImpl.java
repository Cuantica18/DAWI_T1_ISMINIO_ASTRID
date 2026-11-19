package com.cibertec.daw1.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cibertec.daw1.dtos.EmpleadoDTO;
import com.cibertec.daw1.entity.Empleados;
import com.cibertec.daw1.exceptions.ResourceNotFoundException;
import com.cibertec.daw1.repositories.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    private final IEmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(IEmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<EmpleadoDTO> listarEmpleados() {
        return empleadoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public EmpleadoDTO buscarEmpleado(Integer id) {
        Empleados empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con ID: " + id));
        return mapToDTO(empleado);
    }

    @Override
    public EmpleadoDTO registrarEmpleado(EmpleadoDTO dto) {
        Empleados nuevoEmpleado = Empleados.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .email(dto.getEmail())
                .especialidad(dto.getEspecialidad())
                .build();

        Empleados guardado = empleadoRepository.save(nuevoEmpleado);
        return mapToDTO(guardado);
    }

    @Override
    public EmpleadoDTO actualizarEmpleado(Integer id, EmpleadoDTO dto) {
        Empleados existente = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con ID: " + id));

        existente.setNombre(dto.getNombre());
        existente.setApellido(dto.getApellido());
        existente.setEmail(dto.getEmail());
        existente.setEspecialidad(dto.getEspecialidad());

        Empleados actualizado = empleadoRepository.save(existente);
        return mapToDTO(actualizado);
    }

    @Override
    public void eliminarEmpleado(Integer id) {
        if (!empleadoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Empleado no encontrado con ID: " + id);
        }
        empleadoRepository.deleteById(id);
    }

    private EmpleadoDTO mapToDTO(Empleados emp) {
        return EmpleadoDTO.builder()
                .id(emp.getId())
                .nombre(emp.getNombre())
                .apellido(emp.getApellido())
                .email(emp.getEmail())
                .especialidad(emp.getEspecialidad())
                .build();
    }
}