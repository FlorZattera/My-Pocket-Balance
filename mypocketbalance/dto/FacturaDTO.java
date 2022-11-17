package org.ada.mypocketbalance.dto;

import java.time.LocalDate;

public class FacturaDTO {

    private Integer id;
    private int NumeroFactura;
    private float TotalFactura;
    private LocalDate Fecha;

    public FacturaDTO(Integer id, int numeroFactura, float totalFactura, LocalDate fecha) {
        this.id = id;
        NumeroFactura = numeroFactura;
        TotalFactura = totalFactura;
        Fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public int getNumeroFactura() {
        return NumeroFactura;
    }

    public float getTotalFactura() {
        return TotalFactura;
    }

    public LocalDate getFecha() {
        return Fecha;
    }
}
