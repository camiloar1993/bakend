package com.pruebatec.spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Collectors;
import java.util.List;

import com.pruebatec.spring.app.repository.ClienteRepository;
import com.pruebatec.spring.app.controller.Cliente_ORD_FC;
import com.pruebatec.spring.app.controller.num_prom_clientes;
import com.pruebatec.spring.app.model.Cliente;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
// capa servicio para almacenar cliente en la base de datos

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // capa servicio para obtener todos los clientes ordenados por orden alfabetico

    public List<Cliente> obtenerClientesOrdenados() {
        return clienteRepository.findAll().stream()
                .sorted((c1, c2) -> c1.getNombre_completo().compareToIgnoreCase(c2.getNombre_completo()))
                .toList();
    }

// capa servicio para obtener todos los clientes ordenados por fecha de nacimiento

public List<Cliente_ORD_FC> obtenerClientesOrdenadosPorFechaNacimiento() {
    return clienteRepository.findAll().stream()
            .sorted((c2, c1) -> c1.getFecha_nacimiento().compareTo(c2.getFecha_nacimiento()))
            .map(cliente -> new Cliente_ORD_FC(
                    cliente.getNombre_completo(),
                    calcularEdad(cliente.getFecha_nacimiento())
            ))
            .collect(Collectors.toList());
}

private int calcularEdad(LocalDate fechaNacimiento) {
    return Period.between(fechaNacimiento, LocalDate.now()).getYears();
}

// capa servicio para obtener total los clientes y el promedio de edad

public num_prom_clientes obtenerEstadisticasClientes() {
    List<Cliente> clientes = clienteRepository.findAll();

    long cant_Clientes = clientes.size();
    double prom_Edad = clientes.stream()
            .mapToInt(cliente -> calcularEdad(cliente.getFecha_nacimiento()))
            .average()
            .orElse(0.0);

    return new num_prom_clientes(cant_Clientes, prom_Edad);
}

}




