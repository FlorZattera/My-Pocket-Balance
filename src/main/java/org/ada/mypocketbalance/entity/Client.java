package org.ada.mypocketbalance.entity;

import javax.persistence.*;

@Entity
@Table (name= "cliente")
public class Client {

    @Id
    private Integer id;

    @Column (nullable = false)
    private Integer cuil;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    private Integer telefono;

    @Column (nullable = false)
    private String direccion;

    public Client() {
    }

    public Client(Integer id, Integer cuil, String nombre, Integer telefono, String direccion) {
        this.id = id;
        this.cuil = cuil;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCuil() {
        return cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
}
