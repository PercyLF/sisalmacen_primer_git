package com.luna.facturacion.sisalmacen.repository;

import com.luna.facturacion.sisalmacen.entity.Permiso;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.luna.facturacion.sisalmacen.entity.Categoria;
import java.util.List;

@Repository
public interface PermisoRepository extends JpaRepository <Permiso, Integer>{
    List<Permiso> findByNombreContaining(String nombre, Pageable page);

}
