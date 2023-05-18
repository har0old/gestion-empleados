package com.gestion.empleados.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.empleados.Entity.Empleado;
import com.gestion.empleados.repository.EmpleadoRepositorio;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> getEmpleados() {
        return empleadoRepositorio.findAll();
    }
    @Override
    public Empleado getEmpleado(Long id) {
        return empleadoRepositorio.findById(id).get();
    }
    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }
    @Override   
    public void deleteEmpleado(Long id) {
        //Empleado empleadoExistente = getEmpleado(id);
        empleadoRepositorio.deleteById(id);
    }
    @Override
    public Empleado actualizarEmpleado(Long id, Empleado empleado) {
        
        Empleado empleadoExistente = empleadoRepositorio.findById(id)
        .orElseThrow(() -> new NoSuchElementException("No se encontró el empleado con el ID: " + id));
        empleadoExistente.setNombre(empleado.getNombre());
        empleadoExistente.setApellido(empleado.getApellido());
        empleadoExistente.setCorreo(empleado.getCorreo());
        empleadoExistente.setNummero_cliente(empleado.getNummero_cliente());
        empleadoExistente.setSala_creacion(empleado.getSala_creacion());
        empleadoExistente.setCelular(empleado.getCelular());
        empleadoExistente.setNumero_cuenta(empleado.getNumero_cuenta());
        empleadoExistente.setDocumento(empleado.getDocumento());
        empleadoExistente.setCodigo_postal(empleado.getCodigo_postal());
        empleadoExistente.setDelegacion(empleado.getDelegacion());
        empleadoExistente.setMunicipio(empleado.getMunicipio());
        empleadoExistente.setNacionalidad(empleado.getNacionalidad());
        empleadoExistente.setPais(empleado.getPais());
        return empleadoRepositorio.save(empleadoExistente);
    }
}
