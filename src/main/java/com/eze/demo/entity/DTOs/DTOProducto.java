package com.eze.demo.entity.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.math.BigDecimal;

public class DTOProducto {
    
    private final String description;
    private final BigDecimal precio;
    private final int cantidad;
    private final String pictureUrl;
    private final String categoryId;

    @JsonCreator
    public DTOProducto(
            @JsonProperty("description") String description,
            @JsonProperty("precio") BigDecimal precio,
            @JsonProperty("cantidad") int cantidad,
            @JsonProperty("pictureUrl") String pictureUrl,
            @JsonProperty("categoryId") String categoryId) {
        this.description = description;
        this.precio = precio;
        this.cantidad = cantidad;
        this.pictureUrl = pictureUrl;
        this.categoryId = categoryId;
    }
    
    public DTOProducto() {
        this.description = null;
        this.precio = null;
        this.cantidad = 0;
        this.pictureUrl = null;
        this.categoryId = null;
    }
    
    // Getters
    public String getDescription() { return description; }
    public BigDecimal getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public String getPictureUrl() { return pictureUrl; }
    public String getCategoryId() { return categoryId; }
}