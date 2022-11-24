package org.ada.mypocketbalance.dto;

public class DetalleFacturaDTO {

    private int id;
    private int cantidadPedida;
    private int precioUnitario;
    private int precioTotal;

    public DetalleFacturaDTO() {
    }

    public DetalleFacturaDTO(int id, int cantidadPedida, int precioUnitario, int precioTotal) {
        this.id = id;
        this.cantidadPedida = cantidadPedida;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }

    public int getId() {
        return id;
    }

    public int getCantidadPedida() {
        return cantidadPedida;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }
}