package org.ada.mypocketbalance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    private Integer Id;

    @Column (nullable = false)
    private String descripcion;

    @Column (nullable = false)
    private Float precioCosto;

    @Column (nullable = false)
    private Float precioVenta;

    @Column (nullable = false)
    private Integer cantidadDisponible;

    /*@OneToMany (mappedBy = "Producto")
    private List<DetalleFactura> detallesFactura;*/

    public Producto(){

    }

    public Producto(Integer id, String descripcion, float precioCosto, float precioVenta, Integer cantidadDisponible) {
        Id = id;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.cantidadDisponible = cantidadDisponible;
    }
}
