package org.ada.mypocketbalance.controller;

import org.ada.mypocketbalance.service.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Cliente")

public class ClienteController {

    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
}

