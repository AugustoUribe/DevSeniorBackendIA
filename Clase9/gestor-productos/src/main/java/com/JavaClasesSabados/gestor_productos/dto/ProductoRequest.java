package com.JavaClasesSabados.gestor_productos.dto;

import jakarta.validation.constraints.*;

public class ProductoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a cero")
    private Double precio;

    @NotNull(message = "El stock es obligatorio")
    @PositiveOrZero(message = "El stock no puede ser negativo")
    private Integer stock;

    @NotNull(message = "La categoría es obligatoria")
    private Long categoriaId;

    @NotNull(message = "La marca es obligatoria")
    private Long marcaId;

    // getters y setters de todos los campos


    public @NotBlank(message = "El nombre es obligatorio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es obligatorio") String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public @NotNull(message = "El precio es obligatorio") @Positive(message = "El precio debe ser mayor a cero") Double getPrecio() {
        return precio;
    }

    public void setPrecio(@NotNull(message = "El precio es obligatorio") @Positive(message = "El precio debe ser mayor a cero") Double precio) {
        this.precio = precio;
    }

    public @NotNull(message = "El stock es obligatorio") @PositiveOrZero(message = "El stock no puede ser negativo") Integer getStock() {
        return stock;
    }

    public void setStock(@NotNull(message = "El stock es obligatorio") @PositiveOrZero(message = "El stock no puede ser negativo") Integer stock) {
        this.stock = stock;
    }

    public @NotNull(message = "La categoría es obligatoria") Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(@NotNull(message = "La categoría es obligatoria") Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public @NotNull(message = "La marca es obligatoria") Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(@NotNull(message = "La marca es obligatoria") Long marcaId) {
        this.marcaId = marcaId;
    }
}