package com.eze.demo.entity.PruebaConcepto.DTOs;

public class DTOClientePC {

    private String nombre;
    private String email;
    
    public DTOClientePC(String nombre, String email) {
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
