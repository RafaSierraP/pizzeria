package com.bootcamp.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Ingrediente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "El ingrediente debe de tener un nombre")
    private String nombre;

    @NotNull(message = "El ingrediente debe de tener un precio")
    @Min(value = 0, message = "El precio no puede ser negativo")
    private double precio;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Pizza pizza;

    public Ingrediente() {
        super();
    }

    public Ingrediente(long id, @NotNull(message = "El ingrediente debe de tener un nombre") String nombre,
            @NotNull(message = "El ingrediente debe de tener un precio") @Min(value = 0, message = "El precio no puede ser negativo") double precio,
            Pizza pizza) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.pizza = pizza;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

}
