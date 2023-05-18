package com.gestion.empleados.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "empleados")
public class Empleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre", length = 60, nullable = false )
    private String nombre;
    @Column(name="apellido", length = 60, nullable = false)
    private String apellido;
    @Column(name="correo", length = 60, nullable = false, unique = true)
    private String correo;
    @Column(name="nummero_cliente", length = 60)
    private String nummero_cliente;
    @Column(name="sala_creacion", length = 60 )
    private String sala_creacion;
    @Column(name="celular", length = 60 )
    private String celular; 
    @Column(name="numero_cuenta", length = 60 )
    private String numero_cuenta;
    @Column(name="documento", length = 60 )
    private String documento;
    @Column(name="codigo_postal", length = 60 )
    private String codigo_postal; 
    @Column(name="delegacion", length = 60 )
    private String delegacion;
    @Column(name="municipio", length = 60 )
    private String municipio;
    @Column(name="nacionalidad", length = 60 )
    private String nacionalidad;
    @Column(name="pais", length = 60 )
    private String pais;
  
    /* 
    
    public Empleado(){

    }

    public Empleado(Long id, String nombre, String apellido, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

  
    

    */
    
}
