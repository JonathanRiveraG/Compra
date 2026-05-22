package com.compra.farma.dto;

import com.compra.farma.model.ModeloCompra;
import com.compra.farma.model.ModeloFactura;

import org.springframework.stereotype.Component;

@Component
public class CompraMapper {

    public ModeloCompra toEntity(DtoCompra dto) {
        if (dto == null) {
            return null;
        }
        ModeloCompra entity = new ModeloCompra();
        entity.setIdOrdenCompra(dto.idOrdenCompra());
        entity.setRutProveedor(dto.rutProveedor());
        entity.setSku(dto.sku());
        entity.setCantidad(dto.cantidad());
        entity.setTotalCompra(dto.totalCompra());

        if(dto.factura() != null) {
            ModeloFactura facturaEntity = new ModeloFactura();
            facturaEntity.setIdFactura(dto.factura().getIdFactura());
            facturaEntity.setNumeroFactura(dto.factura().getNumeroFactura());
            facturaEntity.setFechaEmision(dto.factura().getFechaEmision());
            facturaEntity.setRutCliente(dto.factura().getRutCliente());
            facturaEntity.setNombreCliente(dto.factura().getNombreCliente());
            facturaEntity.setTotalFactura(dto.factura().getTotalFactura());
            entity.setFactura(facturaEntity);
        }
        return entity;
    }

    public DtoCompra toDTO(ModeloCompra entity) {
        if (entity == null) {
            return null;
        }
        DtoFactura facturaDto = null;
        if(entity.getFactura() != null) {
            facturaDto = new DtoFactura(
                entity.getFactura().getIdFactura(),
                entity.getFactura().getNumeroFactura(),
                entity.getFactura().getFechaEmision(),
                entity.getFactura().getRutCliente(),
                entity.getFactura().getNombreCliente(),
                entity.getFactura().getTotalFactura(),
                null
            );
        }
        return new DtoCompra(
            entity.getIdOrdenCompra(),
            entity.getRutProveedor(),
            entity.getSku(),
            entity.getCantidad(),
            entity.getTotalCompra(),
            facturaDto
        );
    }
}

