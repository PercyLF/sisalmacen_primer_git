package com.luna.facturacion.sisalmacen.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.luna.facturacion.sisalmacen.entity.Categoria;
import java.util.List;

@Repository 
public interface CategoriaRepository extends JpaRepository <Categoria, Integer>{
	List<Categoria> findByNombreContaining(String nombre, Pageable page);

}
