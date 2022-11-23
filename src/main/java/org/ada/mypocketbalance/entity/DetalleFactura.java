package org.ada.mypocketbalance.entity;

import javax.persistence.*;

@Entity
@Table(name = "Detalle_Factura")
public class DetalleFactura {
    @Id
    @Column(nullable = false)
    private int id;

    @Column(name= "cantidad_pedida",nullable = false)
    private int cantidadPedida;

    @Column (name= "precio_total",nullable = false)
    private int precioTotal;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public DetalleFactura() {
    }

    public DetalleFactura(int id, int cantidadPedida, int precioTotal, Factura factura, Producto producto) {
        this.id = id;
        this.cantidadPedida = cantidadPedida;
        this.precioTotal = precioTotal;
        this.factura = factura;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public int getCantidadPedida() {
        return cantidadPedida;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public Producto getProducto() {
        return producto;
    }
}
