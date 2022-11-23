package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.ClienteDTO;
import org.ada.mypocketbalance.entity.Cliente;
import org.ada.mypocketbalance.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

        private final ClienteRepository clienteRepository;

        public ClienteService(ClienteRepository clienteRepository) {

                this.clienteRepository = clienteRepository;
        }

        public List<ClienteDTO> retrieveAll() {

                List<Cliente> clientes = clienteRepository.findAll();

                return clientes.stream()
                        .map(cliente -> mapToDTO(cliente))
                        .collect(Collectors.toList());
        }


        private ClienteDTO mapToDTO(Cliente cliente) {

                ClienteDTO clienteDTO = new ClienteDTO(cliente.getCuil(), cliente.getTelefono(), cliente.getNombre(),
                        cliente.getId(), cliente.getDireccion());

                return clienteDTO;
        }

        private Cliente mapToEntity(ClienteDTO clienteDTO) {
                Cliente cliente = new Cliente(clienteDTO.getId(),clienteDTO.getCuil(),clienteDTO.getNombre(),
                        clienteDTO.getTelefono(),clienteDTO.getDireccion());

                return cliente;

        }
}


