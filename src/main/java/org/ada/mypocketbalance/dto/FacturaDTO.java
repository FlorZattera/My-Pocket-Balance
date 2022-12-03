package org.ada.mypocketbalance.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class FacturaDTO {

    private Integer id;
    @JsonAlias("numero_factura")
    private int numeroFactura;
    @JsonAlias("total_factura")
    private Double totalFactura;/*campo calculado, no se puede almacenar en base de datos porq se va pisando FORMA NORMAL*/
    @JsonAlias("fecha")
    private String fecha;
    @JsonAlias("cliente_id")
    private Integer idCliente;
    @JsonAlias("vendedor_id")
    private Integer idVendedor;
   @JsonProperty("detalle_facturasDTOS")
    private List<DetalleFacturaDTO> detalleFacturaDTOS;

    public FacturaDTO() {
    }

    public FacturaDTO(Integer id, int numeroFactura, Double totalFactura, String fecha, Integer idCliente, Integer idVendedor) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
    }

    public FacturaDTO(Integer id,int numeroFactura, Double totalFactura, String fecha, Integer idCliente, Integer idVendedor, List<DetalleFacturaDTO> detalleFacturaDTOS) {
        this.id= id;
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.detalleFacturaDTOS = detalleFacturaDTOS;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public Integer getId() {
        return id;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Double getTotalFactura() {
        return totalFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public List<DetalleFacturaDTO> getDetalleFacturaDTOS() {
        return detalleFacturaDTOS;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}

