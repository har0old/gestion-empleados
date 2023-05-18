package com.gestion.empleados.service;

import java.util.List;

import com.gestion.empleados.Entity.Empleado;

public interface EmpleadoService {
    
   List<Empleado> getEmpleados();

   Empleado getEmpleado(Long id);

   Empleado saveEmpleado(Empleado empleado);

   Empleado actualizarEmpleado(Long id, Empleado empleado);

   void deleteEmpleado(Long id);
}
