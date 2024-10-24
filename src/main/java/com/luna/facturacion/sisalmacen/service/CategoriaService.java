package com.luna.facturacion.sisalmacen.service;

import com.luna.facturacion.sisalmacen.entity.Categoria;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface CategoriaService {
	public List<Categoria> findAll(Pageable page);
	public List<Categoria> findAll();
	public List<Categoria> finByNombre(String nombre,Pageable page);
	public Categoria findById(int id);
	public Categoria save(Categoria categoria);
	public void delete(int id);
}
