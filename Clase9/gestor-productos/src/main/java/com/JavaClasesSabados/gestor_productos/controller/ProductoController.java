package com.JavaClasesSabados.gestor_productos.controller;



import com.JavaClasesSabados.gestor_productos.dto.ProductoDTO;
import com.JavaClasesSabados.gestor_productos.dto.ProductoRequest;
import com.JavaClasesSabados.gestor_productos.model.*;
import com.JavaClasesSabados.gestor_productos.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService s){ this.productoService = s; }

    @GetMapping
    public List<ProductoDTO> obtenerProductos(){
        return productoService.listarProductos().stream().map(ProductoDTO::new).toList();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<ProductoDTO> obtenerPorCategoria(@PathVariable Long categoriaId){
        return productoService.listarPorCategoria(categoriaId).stream().map(ProductoDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@Valid @RequestBody ProductoRequest req){
        Producto p = new Producto();
        p.setNombre(req.getNombre());
        p.setDescripcion(req.getDescripcion());
        p.setPrecio(req.getPrecio());
        p.setStock(req.getStock());
        Categoria c = new Categoria(); c.setId(req.getCategoriaId()); p.setCategoria(c);
        Marca m = new Marca(); m.setId(req.getMarcaId()); p.setMarca(m);
        Producto guardado = productoService.agregarProducto(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductoDTO(guardado));
    }
}



/*  codigo anteriuor por si no funciona
import com.JavaClasesSabados.gestor_productos.dto.ProductoDTO;
import com.JavaClasesSabados.gestor_productos.model.Producto;
import com.JavaClasesSabados.gestor_productos.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoDTO> obtenerProductos() {
        return productoService.listarProductos()
                .stream()
                .map(ProductoDTO::new)
                .toList();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<ProductoDTO> obtenerPorCategoria(
            @PathVariable Long categoriaId) {
        return productoService.listarPorCategoria(categoriaId)
                .stream()
                .map(ProductoDTO::new)
                .toList();
    }

    @PostMapping
    public ProductoDTO crearProducto(@RequestBody Producto producto) {
        Producto guardado = productoService.agregarProducto(producto);
        return new ProductoDTO(guardado);
    }
*/

