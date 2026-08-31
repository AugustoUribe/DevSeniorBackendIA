
package com.JavaClasesSabados.gestor_productos.model;

import jakarta.persistence.*;

@Entity  //PAra que pueda crear el spring automaticamente las tablas en las base de datos
@Table(name="productos") //Se le llama la tabla a la base de datos para que no quede producto en singular
public class Producto {
    @Id //Para que sepa la tabla de la base de datos que es la primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;


    //ACa estoy haciendo referencia a la relacion base de datos como la Foreing Key
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    //ACa estoy haciendo referencia a la relacion base de datos como la Foreing Key
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public Producto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }



    // getters y setters de todos los campos
}