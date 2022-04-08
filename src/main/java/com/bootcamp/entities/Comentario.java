package com.bootcamp.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "El comentario debe incluir un texto")
    private String texto;

    @NotNull(message = "Se debe puntuar a la pizza")
    @Size(min = 0, max = 10)
    private double puntos;

    @NotNull(message = "El comentario tiene que tener una fecha asociada")
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Pizza pizza;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private User user;

    public Comentario() {
        super();
    }

    public Comentario(long id, @NotNull(message = "El comentario debe incluir un texto") String texto,
            @NotNull(message = "Se debe puntuar a la pizza") @Size(min = 0, max = 10) double puntos,
            @NotNull(message = "El comentario tiene que tener una fecha asociada") LocalDate fecha, Pizza pizza,
            User user) {
        super();
        this.id = id;
        this.texto = texto;
        this.puntos = puntos;
        this.fecha = fecha;
        this.pizza = pizza;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
