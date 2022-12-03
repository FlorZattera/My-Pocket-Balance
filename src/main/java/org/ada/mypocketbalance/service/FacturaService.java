package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.DetalleFacturaDTO;
import org.ada.mypocketbalance.dto.FacturaDTO;
import org.ada.mypocketbalance.entity.*;
import org.ada.mypocketbalance.exceptions.ExistingResourceException;
import org.ada.mypocketbalance.exceptions.ResourceNotFoundException;
import org.ada.mypocketbalance.repository.ClienteRepository;
import org.ada.mypocketbalance.repository.DetalleFacturaRepository;
import org.ada.mypocketbalance.repository.FacturaRepository;
import org.ada.mypocketbalance.repository.VendedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacturaService {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final FacturaRepository facturaRepository;
    private final VendedorRepository vendedorRepository;
    private final ClienteRepository clienteRepository;
    private final DetalleFacturaService detalleFacturaService;
    private final DetalleFacturaMapper detalleFacturaMapper;

    public FacturaService(FacturaRepository facturaRepository, VendedorRepository vendedorRepository, ClienteRepository clienteRepository, DetalleFacturaService detalleFacturaService, DetalleFacturaMapper detalleFacturaMapper) {
        this.facturaRepository = facturaRepository;
        this.vendedorRepository = vendedorRepository;
        this.clienteRepository = clienteRepository;
        this.detalleFacturaService = detalleFacturaService;
        this.detalleFacturaMapper = detalleFacturaMapper;
    }

    public FacturaDTO retrieveById(Integer facturaId) {
        Optional<Factura> factura = facturaRepository.findById(facturaId);
        /*Optional List<DetalleFacturaDTO> detallesFactura = facturaRepository.findById(facturaId);*/
        if (factura.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return mapToDTO(factura.get());
    }

    public List<FacturaDTO> retrieveAll() {
        List<Factura> facturas = facturaRepository.findAll();

        return facturas.stream()
                .map(factura -> mapToDTO(factura))
                .collect(Collectors.toList());
    }

    public void create(FacturaDTO facturaDTO) {
        Optional<Cliente> cliente = clienteRepository.findById(facturaDTO.getIdCliente());
        Optional<Vendedor> vendedor = vendedorRepository.findById(facturaDTO.getIdVendedor());
        if (cliente.isEmpty()) {
            throw new ResourceNotFoundException("el cliente no esta resgistrado");
        }
        if (vendedor.isEmpty()) {
            throw new ResourceNotFoundException("la compra no puede realizarse");
        }
        Factura factura = mapToEntity(facturaDTO, cliente.get(), vendedor.get());
        factura = facturaRepository.save(factura);
        facturaDTO.setId(factura.getId());

    }

    /*public FacturaDTO create(FacturaDTO facturaDTO) {
        Factura factura = mapToEntity(facturaDTO);
        factura = facturaRepository.save(factura);
        if (!CollectionUtils.isEmpty(facturaDTO.getDetalleFacturaDTOS())) {
            detalleFacturaService.create(facturaDTO.getDetalleFacturaDTOS();
        }

        return facturaDTO;
    }*/
 private Factura mapToEntity(FacturaDTO facturaDTO, Cliente cliente, Vendedor vendedor) {
     List<DetalleFactura> detalleFacturas = facturaDTO.getDetalleFacturaDTOS().stream().map(detalleFacturaDTO -> detalleFacturaMapper.mapToEntity(detalleFacturaDTO, null))
             .collect(Collectors.toList());
     Factura factura = new Factura(facturaDTO.getNumeroFactura(), facturaDTO.getTotalFactura(),
                LocalDate.parse(facturaDTO.getFecha(), DATE_TIME_FORMATTER), cliente, vendedor,detalleFacturas);
        return factura;
    }

    private FacturaDTO mapToDTO(Factura factura) {
        List<DetalleFacturaDTO> detalleFacturaDTOS = factura.getDetallesFactura()
                .stream().map(detalleFactura -> detalleFacturaMapper.mapToDTO(detalleFactura))
                .collect(Collectors.toList());
        FacturaDTO facturaDTO = new FacturaDTO(factura.getId(), factura.getNumeroFactura(),
                factura.getTotalFactura(), factura.getFecha().toString(), factura.getCliente().getId(), factura.getVendedor().getId(),detalleFacturaDTOS);
        return facturaDTO;
    }

}



