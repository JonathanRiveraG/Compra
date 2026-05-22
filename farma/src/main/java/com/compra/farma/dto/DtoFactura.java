package com.compra.farma.dto;

import java.util.List;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoFactura {

    private Long idFactura;
    private String numeroFactura;
    private LocalDateTime fechaEmision;

    @NotBlank
    private String rutCliente;

    @NotBlank
    private String nombreCliente;

    private BigDecimal totalFactura;

    @NotEmpty
    private List<DtoDetalle> detalles;



}
