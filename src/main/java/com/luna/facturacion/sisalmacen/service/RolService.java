package com.luna.facturacion.sisalmacen.service;

import com.luna.facturacion.sisalmacen.entity.Rol;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface RolService {
	public List<Rol> findAll(Pageable page);
	public List<Rol> finByNombre(String nombre, Pageable page);
	public Rol findById(int id);
	public Rol save(Rol rol);
	public void delete(int id);
}
