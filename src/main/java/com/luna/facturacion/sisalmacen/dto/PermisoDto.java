package com.luna.facturacion.sisalmacen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PermisoDto {
    private int id;
    private String nombre;
}