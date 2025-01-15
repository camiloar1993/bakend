package com.pruebatec.spring.app.controller;

public class num_prom_clientes {

    private long cant_Clientes;
    private double prom_Edad;

    public num_prom_clientes(long cant_Clientes, double prom_Edad) {
        this.cant_Clientes = cant_Clientes;
        this.prom_Edad = prom_Edad;
    }

    // Getters y Setters
    public long getCantidadClientes() {
        return cant_Clientes;
    }

    public void setCantidadClientes(long cant_Clientes) {
        this.cant_Clientes = cant_Clientes;
    }

    public double getPromedioEdad() {
        return prom_Edad;
    }

    public void setPromedioEdad(double prom_Edad) {
        this.prom_Edad = prom_Edad;
    }


}
