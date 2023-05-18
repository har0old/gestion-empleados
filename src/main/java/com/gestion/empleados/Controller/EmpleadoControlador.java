package com.gestion.empleados.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.Entity.Empleado;
//import com.gestion.empleados.repository.EmpleadoRepositorio;
import com.gestion.empleados.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServiceImpl empleadoService;
    
    @GetMapping
    public List<Empleado> getEmpleados() {
        return empleadoService.getEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado getEmpleado(@PathVariable("id") Long id) {
        return empleadoService.getEmpleado(id);
    }

    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        return ResponseEntity.ok(empleadoService.saveEmpleado(empleado));
    }

    @PutMapping("/{id}")
    public Empleado actualizarProducto(@PathVariable("id") Long id, @RequestBody Empleado empleado) {
        return empleadoService.actualizarEmpleado(id, empleado);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable("id") Long id) {
        empleadoService.deleteEmpleado(id);
    }

 
}
