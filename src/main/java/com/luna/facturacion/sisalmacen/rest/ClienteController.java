package com.luna.facturacion.sisalmacen.rest;

import java.util.List;

import com.luna.facturacion.sisalmacen.dto.CategoriaDto;
import com.luna.facturacion.sisalmacen.dto.ClienteDto;
import com.luna.facturacion.sisalmacen.entity.Cliente;
import com.luna.facturacion.sisalmacen.util.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import com.luna.facturacion.sisalmacen.entity.Cliente;
import com.luna.facturacion.sisalmacen.service.ClienteService;
import com.luna.facturacion.sisalmacen.converter.ClienteConverter;


@RestController
@RequestMapping("/v1/clientes")

public class ClienteController {
    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteConverter converter;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
    ) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<ClienteDto> clientes = converter.fromEntity(service.findAll());
//        return ResponseEntity.ok(categorias);
        return new WrapperResponse(true, "success", clientes).createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> create (@RequestBody ClienteDto cliente) {
        Cliente entity = converter.fromDTO(cliente);
        ClienteDto dto = converter.fromEntity(service.save(entity));
//        return ResponseEntity.ok(dto);
        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> update (@PathVariable("id") int id, @RequestBody ClienteDto cliente) {
        Cliente entity = converter.fromDTO(cliente);
        ClienteDto dto = converter.fromEntity(service.save(entity));
//        return ResponseEntity.ok(dto);
        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable("id") int id) {
        service.delete(id);
//        return ResponseEntity.ok(null);
        return new WrapperResponse(true, "success", null).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById (@PathVariable("id") int id) {
        ClienteDto dto = converter.fromEntity(service.findById(id));

//        return ResponseEntity.ok(dto);
        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.OK);
    }
}
