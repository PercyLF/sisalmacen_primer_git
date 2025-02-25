package com.luna.facturacion.sisalmacen.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.luna.facturacion.sisalmacen.entity.Rol;
import java.util.List;

@Repository 
public interface RolRepository extends JpaRepository <Rol, Integer>{
	List<Rol> findByNombreContaining(String nombre, Pageable page);

}