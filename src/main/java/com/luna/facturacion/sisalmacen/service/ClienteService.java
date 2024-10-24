package com.luna.facturacion.sisalmacen.service;

import com.luna.facturacion.sisalmacen.entity.Cliente;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {
    public List<Cliente> findAll(Pageable page);
    public List<Cliente> findAll();
    public List<Cliente> findByNombre(String nombre, Pageable page);
    public Cliente findById(int id);
    public Cliente save(Cliente cliente);
    public void delete(int id);
}
