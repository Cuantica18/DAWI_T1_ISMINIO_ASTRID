package com.cibertec.daw1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.daw1.entity.Empleados;

public interface IEmpleadoRepository extends JpaRepository<Empleados, Integer> {
 
}