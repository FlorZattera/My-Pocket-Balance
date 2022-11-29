package org.ada.mypocketbalance.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;

public class FacturaDTO {

    private Integer id;
    @JsonAlias ("numero_factura")
    private int numeroFactura;
    @JsonAlias ("total_factura")
    private Double totalFactura;
    private LocalDate fecha; /*Cambiar a string y hacer logica*/
    private Integer idCliente;
    private Integer idVendedor;

    public FacturaDTO() {
    }



    public FacturaDTO(Integer id, int numeroFactura, Double totalFactura, LocalDate fecha) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.fecha = fecha;
    }

    public FacturaDTO(int numeroFactura, Double totalFactura, LocalDate fecha,Integer idCliente, Integer idVendedor) {
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.fecha = fecha;
        this.idCliente=idCliente;
        this.idVendedor=idVendedor;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getFecha() {
        return fecha;
    }
}

