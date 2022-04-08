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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "El campo nombre no puede estar vacio")
    @Size(min = 2, max = 45, message = "El campo nombre tiene que tener entre 2 y 45 caracteres")
    private String nombre;

    @Size(max = 45, message = "El campo apellido tiene que tener entre 2 y 45 caracteres")
    private String apellido;

    @NotNull
    @Size(min = 5, message = "El campo email tiene que tener entre 5 y 45 caracteres")
    private String email;

    @NotNull
    @Size(min = 4, max = 45, message = "La contraseña debe contener al menos 4 caracteres")
    private String passw;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Comentario> comentarios;

    public User() {
        super();
    }

    public User(long id,
            @NotNull(message = "El campo nombre no puede estar vacio") @Size(min = 2, max = 45, message = "El campo nombre tiene que tener entre 2 y 45 caracteres") String nombre,
            @Size(max = 45, message = "El campo apellido tiene que tener entre 2 y 45 caracteres") String apellido,
            @NotNull @Size(min = 5, message = "El campo email tiene que tener entre 5 y 45 caracteres") String email,
            @NotNull @Size(min = 4, max = 45, message = "La contraseña debe contener al menos 4 caracteres") String passw,
            List<Comentario> comentarios) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.passw = passw;
        this.comentarios = comentarios;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

}
