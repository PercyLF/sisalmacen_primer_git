package com.luna.facturacion.sisalmacen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luna.facturacion.sisalmacen.entity.Permiso;
import com.luna.facturacion.sisalmacen.exception.GeneralException;
import com.luna.facturacion.sisalmacen.exception.NoDataFoundException;
import com.luna.facturacion.sisalmacen.exception.ValidateException;
import com.luna.facturacion.sisalmacen.repository.PermisoRepository;
import com.luna.facturacion.sisalmacen.service.PermisoService;
import com.luna.facturacion.sisalmacen.validator.PermisoValidator;

@Service
public class PermisoServiceImpl implements PermisoService{
    @Autowired
    private PermisoRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Permiso> findAll(Pageable page) {
        try {
            List<Permiso> registros=repository.findAll(page).toList();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        }
        catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Permiso> finByNombre(String nombre, Pageable page) {
        try {
            List<Permiso> registros=repository.findByNombreContaining(nombre,page);
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        }
        catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Permiso findById(int id) {
        try {
            Permiso registro=repository.findById(id).
                    orElseThrow(()->new NoDataFoundException("No existe un registro con ese ID"));
            return registro;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        }
        catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional
    public Permiso save(Permiso permiso) {
        try {

            PermisoValidator.save(permiso);
            //Nuevo registro
            if (permiso.getId()==0) {
                Permiso nuevo=repository.save(permiso);
                return nuevo;
            }
            //editar registro
            Permiso registro=repository.findById(permiso.getId()).orElseThrow(()->new NoDataFoundException("No existe un registro con ese ID"));
            registro.setNombre(permiso.getNombre());
            repository.save(registro);
            return registro;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        }
        catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            Permiso registro=repository.findById(id).orElseThrow(()->new NoDataFoundException("No existe un registro con ese ID"));
            repository.delete(registro);
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        }
        catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }

    }

}
