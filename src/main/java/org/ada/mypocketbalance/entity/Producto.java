package org.ada.mypocketbalance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @Column (nullable = false)
    private Integer id;

    @Column (nullable = false)
    private String descripcion;
    @Column (name= "precio_costo",nullable = false)
    private String precioCosto;

    @Column (name= "precio_venta", nullable = false)
    private String precioVenta;

    @Column (name= "cantidad_disponible",nullable = false)
    private Integer cantidadDisponible;

    @ManyToOne
    @JoinColumn (name= "detalle_factura_id")
    private DetalleFactura detalleFactura;

    public Producto() {
    }

    public Producto(Integer id, String descripcion, String precioCosto, String precioVenta, Integer cantidadDisponible) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Producto(Integer id, String descripcion, String precioCosto, String precioVenta, Integer cantidadDisponible, DetalleFactura detalleFactura) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.cantidadDisponible = cantidadDisponible;
        this.detalleFactura = detalleFactura;
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecioCosto() {
        return precioCosto;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }
}