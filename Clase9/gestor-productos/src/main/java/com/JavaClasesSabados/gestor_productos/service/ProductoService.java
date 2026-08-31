package com.JavaClasesSabados.gestor_productos.service;

import com.JavaClasesSabados.gestor_productos.model.Categoria;
import com.JavaClasesSabados.gestor_productos.model.Marca;
import com.JavaClasesSabados.gestor_productos.model.Producto;
import com.JavaClasesSabados.gestor_productos.repository.CategoriaRepository;
import com.JavaClasesSabados.gestor_productos.repository.MarcaRepository;
import com.JavaClasesSabados.gestor_productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final MarcaRepository marcaRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository,
                           CategoriaRepository categoriaRepository,
                           MarcaRepository marcaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.marcaRepository = marcaRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public List<Producto> listarPorCategoria(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }

    public Producto agregarProducto(Producto producto) {
        resolverCategoria(producto);
        resolverMarca(producto);
        return productoRepository.save(producto);
    }

    private void resolverCategoria(Producto producto) {
        if (producto.getCategoria() != null
                && producto.getCategoria().getId() != null) {
            Categoria categoria = categoriaRepository
                    .findById(producto.getCategoria().getId())
                    .orElse(null);
            producto.setCategoria(categoria);
        }
    }

    private void resolverMarca(Producto producto) {
        if (producto.getMarca() != null
                && producto.getMarca().getId() != null) {
            Marca marca = marcaRepository
                    .findById(producto.getMarca().getId())
                    .orElse(null);
            producto.setMarca(marca);
        }
    }
}