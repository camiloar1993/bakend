package com.pruebatec.spring.app.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pcliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="nombre_completo",nullable = false, length = 255)
    private String nombre_completo;

    @Column(name="doc_identidad",nullable = false, length = 50)
    private String doc_identidad;

    @Column(name = "fecha_nacimiento",nullable = false)
    private LocalDate fecha_nacimiento;

    @Column(name="correo_electronico",nullable = false, length = 50)
    private String correo_electronico;


    //  metodo para ingresar usuario a la base de datos en mysql
    
    public void setId(Long id) {
        this.id = id; // asignar el valor del atributo
    }

    public void setNombreCompleto(String nombre_completo) {
        this.nombre_completo = nombre_completo; 
    }

    public void setDocumentoIdentidad(String doc_identidad) {
    this.doc_identidad = doc_identidad;
    }

    public void setCorreoElectronico(String correo_electronico) {
    this.correo_electronico = correo_electronico;
    }

    public void setFechaNacimiento(LocalDate fecha_nacimiento) {
    this.fecha_nacimiento = fecha_nacimiento;
    }

}


