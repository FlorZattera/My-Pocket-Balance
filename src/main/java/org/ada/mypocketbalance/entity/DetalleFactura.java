package org.ada.mypocketbalance.entity;

import javax.persistence.*;

@Entity
@Table(name = "DetalleFactura")

public class DetalleFactura {

    @Id
    private  int id;

    @Column(nullable = false)
    private int CantidadPedida;

    @Column (nullable = false)
    private int PrecioTotal;

    /*@ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public DetalleFactura() {
    }*/

    public DetalleFactura(int id, int cantidadPedida, int precioTotal) {
        this.id = id;
        CantidadPedida = cantidadPedida;
        PrecioTotal = precioTotal;
    }

    public int getId() {
        return id;
    }

    public int getCantidadPedida() {
        return CantidadPedida;
    }

    public int getPrecioTotal() {
        return PrecioTotal;
    }
}
