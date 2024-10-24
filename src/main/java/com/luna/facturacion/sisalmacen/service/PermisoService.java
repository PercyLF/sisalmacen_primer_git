package com.luna.facturacion.sisalmacen.service;

import com.luna.facturacion.sisalmacen.entity.Permiso;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface PermisoService {
    public List<Permiso> findAll(Pageable page);
    public List<Permiso> finByNombre(String nombre,Pageable page);
    public Permiso findById(int id);
    public Permiso save(Permiso permiso);
    public void delete(int id);
}
