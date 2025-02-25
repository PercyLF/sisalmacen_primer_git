package com.luna.facturacion.sisalmacen.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.luna.facturacion.sisalmacen.entity.Cliente;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    List<Cliente> findByNombreContaining(String nombre, Pageable page);
}

