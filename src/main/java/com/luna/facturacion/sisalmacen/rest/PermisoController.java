package com.luna.facturacion.sisalmacen.rest;

import java.util.List;

import com.luna.facturacion.sisalmacen.dto.PermisoDto;
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

import com.luna.facturacion.sisalmacen.entity.Permiso;
import com.luna.facturacion.sisalmacen.service.PermisoService;
import com.luna.facturacion.sisalmacen.converter.PermisoConverter;


@RestController
@RequestMapping("/v1/permisos")
public class PermisoController {
    @Autowired
    private PermisoService service;

    @Autowired
    private PermisoConverter converter;

    @GetMapping
    public ResponseEntity<List<PermisoDto>> findAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
    ) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<PermisoDto> permisos = converter.fromEntity(service.findAll(page));
//        return ResponseEntity.ok(permisos);
        return new WrapperResponse(true, "success", permisos).createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PermisoDto> create (@RequestBody PermisoDto permiso) {
        Permiso entity = converter.fromDTO(permiso);
        PermisoDto dto = converter.fromEntity(service.save(entity));
//        return ResponseEntity.ok(dto);
        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermisoDto> update (@PathVariable("id") int id, @RequestBody PermisoDto permiso) {
        Permiso entity = converter.fromDTO(permiso);
        PermisoDto dto = converter.fromEntity(service.save(entity));
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
    public ResponseEntity<PermisoDto> findById (@PathVariable("id") int id) {
        PermisoDto dto = converter.fromEntity(service.findById(id));

//        return ResponseEntity.ok(dto);
        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.OK);
    }
}