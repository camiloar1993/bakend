package com.pruebatec.spring.app.controller;

public class Cliente_ORD_FC {

    private String nombre;
    private int edad;

    public Cliente_ORD_FC(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
     // obtener el valor del atributo
    public String getNombre() {
        return nombre;
    }
     // asignar el valor del atributo
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
