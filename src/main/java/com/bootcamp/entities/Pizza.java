package com.bootcamp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "La pizza debería tener un nombre")
    @Size(min = 3, max = 45)
    private String nombre;

    @NotNull
    @Size(max = 255)
    private String foto;

    @NotNull
    @Min(value = 2)
    private double precio;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pizza")
    private List<Comentario> comentarios;

    @JsonIgnore
    @NotNull(message = "La pizza debe llevar ingredientes. Listopanes")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pizza")
    private List<Ingrediente> ingredientes;

    public Pizza() {
        super();
    }

    public Pizza(long id, @NotNull(message = "La pizza debería tener un nombre") @Size(min = 3, max = 45) String nombre,
            @NotNull @Size(max = 255) String foto, @NotNull @Min(2) double precio, List<Comentario> comentarios,
            @NotNull(message = "La pizza debe llevar ingredientes. Listopanes") List<Ingrediente> ingredientes) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.precio = precio;
        this.comentarios = comentarios;
        this.ingredientes = ingredientes;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

}
