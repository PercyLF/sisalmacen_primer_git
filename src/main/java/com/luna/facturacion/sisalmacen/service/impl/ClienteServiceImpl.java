package com.luna.facturacion.sisalmacen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luna.facturacion.sisalmacen.entity.Cliente;
import com.luna.facturacion.sisalmacen.exception.GeneralException;
import com.luna.facturacion.sisalmacen.exception.NoDataFoundException;
import com.luna.facturacion.sisalmacen.exception.ValidateException;
import com.luna.facturacion.sisalmacen.repository.ClienteRepository;
import com.luna.facturacion.sisalmacen.service.ClienteService;
import com.luna.facturacion.sisalmacen.validator.ClienteValidator;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> findAll(Pageable page) {
        try {
            List<Cliente> registros = repository.findAll(page).toList();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidorr");
        }
    }

    @Override
    public List<Cliente> findAll() {
        try {
            List<Cliente> registros = repository.findAll();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidorr");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findByNombre(String nombre, Pageable page) {
        try {
            List<Cliente> registros = repository.findByNombreContaining(nombre, page);
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(int id) {
        try {
            Cliente registro = repository.findById(id)
                    .orElseThrow(() -> new NoDataFoundException("No existe un registro como ese id"));
            return registro;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        try {
            ClienteValidator.save(cliente);

            if(cliente.getId() == 0) {
                Cliente nuevo = repository.save(cliente);
                return nuevo;
            }

            Cliente registro = repository.findById(cliente.getId())
                    .orElseThrow(() -> new NoDataFoundException("No existe un registro como ese id"));
            registro.setNombre(cliente.getNombre());
            registro.setTipoDocumento(cliente.getTipoDocumento());
            registro.setNumeroDocumento(cliente.getNumeroDocumento());
            registro.setTelefono(cliente.getTelefono());
            registro.setEmail(cliente.getEmail());
            repository.save(registro);

            return registro;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            Cliente registro = repository.findById(id)
                    .orElseThrow(() -> new NoDataFoundException("No existe un registro como ese id"));
            repository.delete(registro);
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }
}
