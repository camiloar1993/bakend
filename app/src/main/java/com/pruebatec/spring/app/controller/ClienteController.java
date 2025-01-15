
// importacion de framework

package com.pruebatec.spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.pruebatec.spring.app.service.ClienteService;
import com.pruebatec.spring.app.model.Cliente;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

// servicio 1 almacenar cliente en la base de datos, implementado haciendo push 1

    @PostMapping ("/guadarcliente")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.guardarCliente(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

//servicio 2 Ruta para obtener datos de clientes ordenados alfabéticamente implementado haciendo push 2

@GetMapping("/clientes/orden_alfabetico")
public List<Cliente> obtenerClientesOrdenados() {
        return clienteService.obtenerClientesOrdenados();
    }

 //servicio 3 Ruta para obtener datos de clientes ordenados por edad, implementado haciendo push 3

 @GetMapping("/clientes/ordenados_fecha")
 public List<Cliente_ORD_FC> obtenerClientesOrdenadosPorFechaNacimiento() {
     return clienteService.obtenerClientesOrdenadosPorFechaNacimiento();
 }

  //servicio 4 Ruta para obtener la cantidad total de clientes y su promedio de edad, implementado haciendo push 3

  @GetMapping("/cliente/numero_promedio")
  public num_prom_clientes obtenerEstadisticasClientes() {
      return clienteService.obtenerEstadisticasClientes();

    }
   // Servicio 4 para mostrar todos los clientes que estan almacenados en la base de datos

   @GetMapping("/clientes")
    public List<Cliente> findAll() {
        return clienteService.findAll();
  }

}