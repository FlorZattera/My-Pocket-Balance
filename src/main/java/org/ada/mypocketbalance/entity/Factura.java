package org.ada.mypocketbalance.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "Factura")
public class Factura {

    @Id
    private Integer id;

    @Column (nullable = false)
    private Integer NumeroFactura;

    @Column (nullable = false)
    private Float TotalFactura;

    @Column (nullable = false)
    private LocalDate Fecha;

   /* @OneToMany (mappedBy = "Factura")
    private List<DetalleFactura> detallesFactura;

    /*@ManyToOne
    @JoinColumn(name = "Client_id")
    private Cliente client;*/

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;


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
