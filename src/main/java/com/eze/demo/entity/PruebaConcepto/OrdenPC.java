package com.eze.demo.entity.PruebaConcepto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class OrdenPC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String preferenceId;

    @OneToMany
    private List<ProductoPC> productos;

    public OrdenPC(String preferenceId, List<ProductoPC> productos) {
        this.preferenceId = preferenceId;
        this.productos = productos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
    }

    public List<ProductoPC> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoPC> productos) {
        this.productos = productos;
    }
}
