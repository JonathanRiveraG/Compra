package com.compra.farma.service;

import org.springframework.stereotype.Service;
import com.compra.farma.dto.DtoCompra;
import com.compra.farma.model.ModeloCompra;
import com.compra.farma.repository.RepositorioCompra;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioCompra {

    private final RepositorioCompra repositorioCompra;

    public List<ModeloCompra> obtenerCompras() {
        return repositorioCompra.findAll();
    }

    public ModeloCompra buscarPorId(Long id){
        return repositorioCompra.findById(id).orElseThrow(() -> new RuntimeException("Orden no encotrada co Id: " + id));

    }

    public ModeloCompra crearCompra(DtoCompra dto){
        ModeloCompra compra = new ModeloCompra();
        compra.setRutProveedor(dto.rutProveedor());
        compra.setSku(dto.sku());
        return repositorioCompra.save(compra);

    }

    public void eliminarCompra(Long id){
        repositorioCompra.deleteById(id);
    }

}
