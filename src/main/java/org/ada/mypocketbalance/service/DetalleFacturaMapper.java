package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.DetalleFacturaDTO;
import org.ada.mypocketbalance.dto.FacturaDTO;
import org.ada.mypocketbalance.entity.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DetalleFacturaMapper {

    public DetalleFacturaDTO mapToDTO (DetalleFactura detalleFactura) {
        DetalleFacturaDTO detalleFacturaDTO = new DetalleFacturaDTO(detalleFactura.getCantidadPedida(), detalleFactura.getPrecioTotal()
                , detalleFactura.getProducto().getId(), detalleFactura.getFactura().getId());
        detalleFacturaDTO.setId(detalleFactura.getId());

        return detalleFacturaDTO;
    }

    public DetalleFactura mapToEntity(DetalleFacturaDTO detalleFacturaDTO, Producto producto) {
        DetalleFactura detalleFactura = new DetalleFactura(detalleFacturaDTO.getCantidadPedida(), detalleFacturaDTO.getPrecioTotal(), producto);

        return detalleFactura;
    }
}
