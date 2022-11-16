package org.ada.mypocketbalance.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table (name = "Factura")
public class Factura {

    @Id
    private Integer id;

    @Column (nullable = false)
    private int NumeroFactura;

    @Column (nullable = false)
    private float TotalFactura;

    @Column (nullable = false)
    private LocalDate Fecha;


    public Factura() {
    }

    public Factura(Integer id, int numeroFactura, float totalFactura, LocalDate fecha) {
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
