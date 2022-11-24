package org.ada.mypocketbalance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Detalle_Factura")
public class DetalleFactura {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "cantidad_pedida", nullable = false)
    private Integer cantidadPedida;

    @Column(name = "precio_unitario")
    private Integer precioUnitario;

    @Column(name = "precio_total", nullable = false)
    private Integer precioTotal;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @OneToMany
    private List<Producto> productos;

    public DetalleFactura() {

    }

    public DetalleFactura(Integer id, Integer cantidadPedida, Integer precioUnitario, Integer precioTotal, Factura factura, List<Producto> productos) {
        this.id = id;
        this.cantidadPedida = cantidadPedida;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.factura = factura;
        this.productos = productos;
    }

    public DetalleFactura(Integer id, Integer cantidadPedida, Integer precioUnitario, Integer precioTotal, Factura factura) {
        this.id = id;
        this.cantidadPedida = cantidadPedida;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.factura = factura;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCantidadPedida() {
        return cantidadPedida;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}





