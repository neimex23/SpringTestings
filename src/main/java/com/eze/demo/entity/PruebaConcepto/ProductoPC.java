package com.eze.demo.entity.PruebaConcepto;

import java.math.BigDecimal;

import jakarta.persistence.Entity;


@Entity
public class ProductoPC {
    private final String internalId = java.util.UUID.randomUUID().toString();

    private String description;
    private BigDecimal precio;
    private int cantidad;
    private String pictureUrl;
    private String categoryId;

    public ProductoPC(String description, BigDecimal precio, int cantidad, String pictureUrl, String categoryId) {
        this.description = description;
        this.precio = precio;
        this.cantidad = cantidad;
        this.pictureUrl = pictureUrl;
        this.categoryId = categoryId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getPictureUrl() {
        return pictureUrl;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getInternalId() {
        return internalId;
    }
}
