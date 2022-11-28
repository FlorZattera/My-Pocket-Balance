package org.ada.mypocketbalance.service;



import org.ada.mypocketbalance.dto.ClienteDTO;
import org.ada.mypocketbalance.dto.ProductoDTO;
import org.ada.mypocketbalance.dto.VendedorDTO;
import org.ada.mypocketbalance.entity.Cliente;
import org.ada.mypocketbalance.entity.Producto;
import org.ada.mypocketbalance.entity.Vendedor;

import org.ada.mypocketbalance.dto.ProductoDTO;

import org.ada.mypocketbalance.exceptions.ExistingResourceException;
import org.ada.mypocketbalance.exceptions.ResourceNotFoundException;
import org.ada.mypocketbalance.repository.ProductoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private ProductoService productoService;

    public ProductoService(ProductoRepository productoRepository) {

        this.productoRepository = productoRepository;
    }
    public List<ProductoDTO> retrieveAll() {

        List<Producto> productos = productoRepository.findAll();

        return productos.stream()
                .map(producto -> mapToDTO(producto))
                .collect(Collectors.toList());
    }

    public ProductoDTO create(ProductoDTO productoDTO) {
        Producto producto = mapToEntity(productoDTO);
        checkForExistingProducto(producto.getId());
        producto = productoRepository.save(producto);
        return productoDTO;
    }

    private void checkForExistingProducto(Integer productoId) {
        if (productoRepository.existsById(productoId)) {
            throw new ExistingResourceException();
        }
    }

    private ProductoDTO mapToDTO(Producto producto) {

        ProductoDTO productoDTO = new ProductoDTO(producto.getId(), producto.getDescripcion(), producto.getPrecioCosto(),
                producto.getPrecioVenta(), producto.getCantidadDisponible());

        return productoDTO;
    }


    private Producto mapToEntity(ProductoDTO productoDTO) {
        Producto producto = new Producto(productoDTO.getId(), productoDTO.getDescripcion(), productoDTO.getPrecioCosto(),
                productoDTO.getPrecioVenta(), productoDTO.getCantidadDisponible());

        return producto;
    }
    public void delete(Integer productoId) {
        try {
            productoRepository.deleteById(productoId);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException();
        }
    }
}


