// capa de repositorio

package com.pruebatec.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pruebatec.spring.app.model.Cliente;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}

