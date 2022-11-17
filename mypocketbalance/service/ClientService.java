package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.repository.ClientRepository;
import org.ada.mypocketbalance.repository.DetalleFacturaRepository;

public class ClientService {

        private final ClientRepository clientRepository;

        public ClientService(ClientRepository clientRepository) {
                this.clientRepository = clientRepository;
        }
}
