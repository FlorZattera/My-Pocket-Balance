package org.ada.mypocketbalance.controller;


import org.ada.mypocketbalance.entity.Factura;
import org.ada.mypocketbalance.service.FacturaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/Factura")

public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

}
