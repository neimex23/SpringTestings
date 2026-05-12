package com.eze.demo.entity;

import com.eze.demo.entity.Enums.EnumRoles;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario {
    private String password;

    protected Administrador() {
    }

    public Administrador(String nombre, String email, String urlImagen, EnumRoles rol, String password) {
        super(nombre, email, urlImagen, rol);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
