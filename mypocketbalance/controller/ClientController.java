package org.ada.mypocketbalance.controller;

import org.ada.mypocketbalance.service.ClientService;
import org.ada.mypocketbalance.service.ProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Client")

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

}
