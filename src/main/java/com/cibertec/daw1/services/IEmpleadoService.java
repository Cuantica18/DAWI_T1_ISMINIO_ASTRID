package com.cibertec.daw1.services;

import java.util.List;
import com.cibertec.daw1.dtos.EmpleadoDTO;

public interface IEmpleadoService {
    List<EmpleadoDTO> listarEmpleados();
    EmpleadoDTO buscarEmpleado(Integer id);
    EmpleadoDTO registrarEmpleado(EmpleadoDTO dto);
    EmpleadoDTO actualizarEmpleado(Integer id, EmpleadoDTO dto);
    void eliminarEmpleado(Integer id);
}