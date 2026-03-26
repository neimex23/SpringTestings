package com.eze.demo.entity;

public class DtoCliente {

    private String nombre;
    private String email;
    
    public DtoCliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    
}
