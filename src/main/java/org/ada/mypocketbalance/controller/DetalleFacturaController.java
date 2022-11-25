package org.ada.mypocketbalance.controller;
import org.ada.mypocketbalance.dto.DetalleFacturaDTO;
import org.ada.mypocketbalance.service.DetalleFacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/DetalleFactura")

public class DetalleFacturaController {
        private final DetalleFacturaService detalleFacturaService;

        public DetalleFacturaController(DetalleFacturaService detalleFacturaService) {
            this.detalleFacturaService = detalleFacturaService;
        }
    @PostMapping
    public ResponseEntity.BodyBuilder create(@RequestBody DetalleFacturaDTO detalleFacturaDTO) {
        detalleFacturaService.create(detalleFacturaDTO);
        return ResponseEntity.accepted();
    }


    }

