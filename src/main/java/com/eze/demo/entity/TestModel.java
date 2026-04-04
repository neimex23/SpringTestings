package com.eze.demo.entity;

public class TestModel {
     private String mensaje;

    public TestModel() {} 

    public TestModel(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
