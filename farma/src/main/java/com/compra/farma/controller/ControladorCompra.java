package com.compra.farma.controller;

import com.compra.farma.dto.DtoCompra;
import com.compra.farma.model.ModeloCompra;
import com.compra.farma.service.ServicioCompra;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping.*;

@RestController
@RequestMapping("/api/compras")
@RequiredArgsConstructor
public class ControladorCompra {

    private final ServicioCompra servicioCompra;

    @GetMapping
    public List<ModeloCompra> listar(){
        return servicioCompra.obtenerCompras();
    }

    @GetMapping("/{id}")
    public ModeloCompra obtenerPorId(@PathVariable Long id){
        return servicioCompra.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<ModeloCompra> crearCompra(@Valid @RequestBody DtoCompra dto){
        ModeloCompra compraCreada = servicioCompra.crearCompra(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(compraCreada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <void> eliminarCompra(@PathVariable Long Id){
        servicioCompra.eliminarCompra(Id);
        return ResponseEntity.noContent().build();
    }
}

