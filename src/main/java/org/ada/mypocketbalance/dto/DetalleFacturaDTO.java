package org.ada.mypocketbalance.dto;

public class DetalleFacturaDTO {

    private  int id;
    private int CantidadPedida;
    private int PrecioTotal;

    public DetalleFacturaDTO(int id, int cantidadPedida, int precioTotal) {
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
