package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.ClientDTO;
import org.ada.mypocketbalance.entity.Client;
import org.ada.mypocketbalance.repository.ClientRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ClientService {

        private final ClientRepository clientRepository;

        public ClientService(ClientRepository clientRepository) {
                this.clientRepository = clientRepository;
        }

        public List<ClientDTO> retrieveAll() {

                List<Client> clients = clientRepository.findAll();

                return clients.stream()
                        .map(client -> mapToDTO(client))
                        .collect(Collectors.toList());
        }

        private ClientDTO mapToDTO(Client client) {

                ClientDTO clientDTO = new ClientDTO(client.getCuil(), client.getTelefono(), client.getNombre(),
                        client.getId(), client.getDireccion());

                return clientDTO;
        }

        private Client mapToEntity(ClientDTO clientDTO) {
                Client client = new Client(clientDTO.getCuil(), clientDTO.getTelefono(), clientDTO.getNombre(),
                        clientDTO.getId(), clientDTO.getDireccion());

                return client;

        }
}

