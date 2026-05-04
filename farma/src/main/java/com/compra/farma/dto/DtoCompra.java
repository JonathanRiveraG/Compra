package com.compra.farma.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DtoCompra(

    @NotBlank(message = "El rut del proveedor es obligatorio")
    String rutProveedor,

    @NotNull(message = "El sku es obligatorio")
    @Positive(message = "El sku debe ser mayor a 0")
    Integer sku

){}

