package com.example.Restaurante.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "plato")
    private List<DetallePedido> detalles;

    @ManyToMany
    @JoinTable(
            name = "reserva_plato",
            joinColumns = @JoinColumn(name = "plato_id"),
            inverseJoinColumns = @JoinColumn(name = "reserva_id")
    )
    private List<Reserva> reservas;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}