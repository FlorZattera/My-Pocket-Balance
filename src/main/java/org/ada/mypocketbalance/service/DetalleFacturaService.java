package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.DetalleFacturaDTO;
import org.ada.mypocketbalance.entity.*;
import org.ada.mypocketbalance.exceptions.ResourceNotFoundException;
import org.ada.mypocketbalance.repository.DetalleFacturaRepository;
import org.ada.mypocketbalance.repository.FacturaRepository;
import org.ada.mypocketbalance.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetalleFacturaService {

    private final DetalleFacturaRepository detalleFacturaRepository;
    private final ProductoRepository productoRepository;
    private final FacturaRepository facturaRepository;


    public DetalleFacturaService(DetalleFacturaRepository detalleFacturaRepository, ProductoRepository productoRepository, FacturaRepository facturaRepository) {
        this.detalleFacturaRepository = detalleFacturaRepository;
        this.productoRepository = productoRepository;
        this.facturaRepository = facturaRepository;
    }
    public List<DetalleFacturaDTO> mapToDTOS(List<DetalleFactura> detallesFacturas) {

        return detallesFacturas.stream()
                .map(detalleFactura -> mapToDTO(detalleFactura))
                .collect(Collectors.toList());
    }

    private DetalleFacturaDTO mapToDTO(DetalleFactura detalleFactura) {
        DetalleFacturaDTO detalleFacturaDTO = new DetalleFacturaDTO(detalleFactura.getCantidadPedida(),detalleFactura.getPrecioTotal()
        ,detalleFactura.getProducto().getId(),detalleFactura.getProducto().getId());
        detalleFacturaDTO.setId(detalleFactura.getId());

        return detalleFacturaDTO;
    }


    public void create(DetalleFacturaDTO detalleFacturaDTO) {
        Optional <Factura> factura= facturaRepository.findById(detalleFacturaDTO.getIdFactura());
        Optional<Producto> producto= productoRepository.findById(detalleFacturaDTO.getIdProducto());
        if (producto.isEmpty()){
            throw new ResourceNotFoundException("el producto no se encuentra");
        } if (factura.isEmpty()){
            throw new ResourceNotFoundException("La factura no existe");
        }
        DetalleFactura detalleFactura= mapToEntity (detalleFacturaDTO,producto.get());
        detalleFactura= detalleFacturaRepository.save(detalleFactura);
        detalleFacturaDTO.setId(detalleFactura.getId());
    }
    public void create(List<DetalleFacturaDTO> detalleFacturaDTOS,Producto producto) {
        List<DetalleFactura> detallesFactura = detalleFacturaDTOS.stream()
                .map(detalleFacturaDTO -> mapToEntity(detalleFacturaDTO,producto))
                .collect(Collectors.toList());
        detalleFacturaRepository.saveAll(detallesFactura);
    }

    private DetalleFactura mapToEntity(DetalleFacturaDTO detalleFacturaDTO, Producto producto) {
        DetalleFactura detalleFactura = new DetalleFactura(detalleFacturaDTO.getCantidadPedida(),detalleFacturaDTO.getPrecioTotal(),producto);

        return detalleFactura;
    }



}
