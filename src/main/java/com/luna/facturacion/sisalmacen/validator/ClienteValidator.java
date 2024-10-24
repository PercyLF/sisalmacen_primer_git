package com.luna.facturacion.sisalmacen.validator;

import com.luna.facturacion.sisalmacen.entity.Cliente;
import com.luna.facturacion.sisalmacen.exception.ValidateException;

public class ClienteValidator {
    public static void save(Cliente registro) {
        if(registro.getNombre() == null || registro.getNombre().trim().isEmpty()) {
            throw new ValidateException("El nombre es requerido");
        }
        if(registro.getNombre().length() > 70) {
            throw new ValidateException("El nombre no debe exceder los 70 caracteres");
        }
    }
}
