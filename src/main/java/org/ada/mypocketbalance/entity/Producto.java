package org.ada.mypocketbalance.entity;

import javax.persistence.*;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @Column (nullable = false)
    private Integer id;

    @Column (nullable = false)
    private String descripcion;

    @Column (name= "precio_costo",nullable = false)
    private Float precioCosto;

    @Column (name= "precio_venta", nullable = false)
    private Float precioVenta;

    @Column (name= "cantidad_disponible",nullable = false)
    private Integer cantidadDisponible;

    @ManyToOne
    @JoinColumn (name= "detalle_factura_id")
    private DetalleFactura detalleFactura;

    public Producto(Integer id, String descripcion, Float precioCosto, Float precioVenta, Integer cantidadDisponible){
    }

    public Producto(Integer id, String descripcion, Float precioCosto, Float precioVenta, Integer cantidadDisponible, DetalleFactura detalleFactura) {
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

    public Float getPrecioCosto() {
        return precioCosto;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }
}
