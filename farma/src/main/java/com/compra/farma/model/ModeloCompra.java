package com.compra.farma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compra")

public class ModeloCompra {

    @Id
    private Long idOrdenCompra;

    @Column(nullable = false)
    private String rutProveedor;

    @Column(nullable = false)
    private Integer sku;

}