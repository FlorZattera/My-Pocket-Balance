package org.ada.mypocketbalance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleFactura")

public class DetalleFactura {

    @Id
    private  int id;

    @Column(nullable = false)
    private int CantidadPedida;

    @Column (nullable = false)
    private int PrecioTotal;

    public DetalleFactura() {
    }

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
