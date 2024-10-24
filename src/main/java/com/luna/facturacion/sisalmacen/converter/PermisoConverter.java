package com.luna.facturacion.sisalmacen.converter;

import com.luna.facturacion.sisalmacen.dto.PermisoDto;
import com.luna.facturacion.sisalmacen.entity.Permiso;
import org.springframework.stereotype.Component;

@Component

public class PermisoConverter extends AbstractConverter <Permiso, PermisoDto>{

    @Override
    public PermisoDto fromEntity(Permiso entity) {
        if (entity == null) return null;
        /*CategoriaDto dto = new CategoriaDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());*/
        return PermisoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    public Permiso fromDTO(PermisoDto dto) {
        if (dto == null) return null;
        return Permiso.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .build();

    }
}
