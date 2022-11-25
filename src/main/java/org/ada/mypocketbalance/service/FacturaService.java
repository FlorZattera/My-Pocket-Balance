package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.FacturaDTO;
import org.ada.mypocketbalance.entity.Factura;
import org.ada.mypocketbalance.repository.DetalleFacturaRepository;
import org.ada.mypocketbalance.repository.FacturaRepository;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;
    private Factura facturaDTO;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public void create(FacturaDTO facturaDTO) {

    }
}
