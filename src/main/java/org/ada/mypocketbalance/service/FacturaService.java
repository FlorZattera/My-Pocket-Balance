package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.FacturaDTO;
import org.ada.mypocketbalance.entity.Cliente;
import org.ada.mypocketbalance.entity.Factura;
import org.ada.mypocketbalance.entity.Vendedor;
import org.ada.mypocketbalance.exceptions.ResourceNotFoundException;
import org.ada.mypocketbalance.repository.ClienteRepository;
import org.ada.mypocketbalance.repository.DetalleFacturaRepository;
import org.ada.mypocketbalance.repository.FacturaRepository;
import org.ada.mypocketbalance.repository.VendedorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacturaService {
    private final FacturaRepository facturaRepository;
    private final VendedorRepository vendedorRepository;
    private final ClienteRepository clienteRepository;

    public FacturaService(FacturaRepository facturaRepository, VendedorRepository vendedorRepository, ClienteRepository clienteRepository) {
        this.facturaRepository = facturaRepository;
        this.vendedorRepository = vendedorRepository;
        this.clienteRepository = clienteRepository;
    }

    public void create (FacturaDTO facturaDTO) {
        Optional<Vendedor> vendedor= vendedorRepository.findById(facturaDTO.getIdVendedor());
        Optional<Cliente> cliente= clienteRepository.findById(facturaDTO.getIdCliente());
        if (vendedor.isEmpty()){
            throw new ResourceNotFoundException("La venta no se puede realizar");
        } if (cliente.isEmpty()) {
            throw new ResourceNotFoundException("El cliente no esta resgitrado en nuestra base de datos");
        }
        Factura factura= mapToEntity (facturaDTO,vendedor.get(),cliente.get());
        factura= facturaRepository.save(factura);
        /*factura=detalleFacturaRepo*/
        facturaDTO.setId(factura.getId());
    }

    private Factura mapToEntity(FacturaDTO facturaDTO, Vendedor vendedor, Cliente cliente) {
        Factura factura= new Factura(facturaDTO.getNumeroFactura(),facturaDTO.getTotalFactura(),facturaDTO.getFecha(),cliente,vendedor);

        return factura;
    }
    public List<FacturaDTO> mapToDTOS(List<Factura> facturas) {

        return facturas.stream()
                .map(factura -> mapToDTO(factura))
                .collect(Collectors.toList());
    }

    private FacturaDTO mapToDTO(Factura factura) {
        FacturaDTO facturaDTO= new FacturaDTO(factura.getNumeroFactura(),factura.getTotalFactura(),factura.getFecha(),factura.getVendedor().getId(),factura.getCliente().getId());
        return facturaDTO;
        }

    public FacturaDTO retrieveById( Integer facturaId) {
        Optional<Factura> factura = facturaRepository.findById(facturaId);
        if (factura.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return mapToDTO(factura.get());
    }
    }



