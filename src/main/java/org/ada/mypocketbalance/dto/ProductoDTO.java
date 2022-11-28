package org.ada.mypocketbalance.dto;

import org.ada.mypocketbalance.entity.Producto;

import java.util.Collection;
import java.util.List;

public class ProductoDTO {

    private Integer id;
    private String descripcion;
    private String precioCosto;
    private String precioVenta;
    private Integer cantidadDisponible;

    public ProductoDTO(){

    }

    public ProductoDTO(Integer id, String descripcion, String precioCosto, String precioVenta, Integer cantidadDisponible) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.cantidadDisponible = cantidadDisponible;
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

    public List <ProductoDTO> getProductosDTOS() {
        return getProductosDTOS();
    }
}
