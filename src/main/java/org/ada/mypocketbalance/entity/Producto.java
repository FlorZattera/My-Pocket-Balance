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
    private Float precioCosto;

    @Column (name= "precio_venta", nullable = false)
    private Float precioVenta;

    @Column (name= "cantidad_pedida",nullable = false)
    private Integer cantidadDisponible;

    @OneToMany (mappedBy = "producto")
    private List<DetalleFactura> detallesFactura;

    public Producto(){
    }

    public Producto(Integer id, String descripcion, Float precioCosto, Float precioVenta, Integer cantidadDisponible, List<DetalleFactura> detallesFactura) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.cantidadDisponible = cantidadDisponible;
        this.detallesFactura = detallesFactura;
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

    public List<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }
}
