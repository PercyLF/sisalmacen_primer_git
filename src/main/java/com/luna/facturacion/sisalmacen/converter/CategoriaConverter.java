package com.luna.facturacion.sisalmacen.converter;

import com.luna.facturacion.sisalmacen.dto.CategoriaDto;
import com.luna.facturacion.sisalmacen.entity.Categoria;
import org.springframework.stereotype.Component;

@Component

public class CategoriaConverter extends AbstractConverter <Categoria, CategoriaDto>{

    @Override
    public CategoriaDto fromEntity(Categoria entity) {
        if (entity == null) return null;
        /*CategoriaDto dto = new CategoriaDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());*/
        return CategoriaDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .build();
    }

    @Override
    public Categoria fromDTO(CategoriaDto dto) {
        if (dto == null) return null;
        return Categoria.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .build();

    }
}
