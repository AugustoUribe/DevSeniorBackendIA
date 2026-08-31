package com.JavaClasesSabados.gestor_productos.repository;

import com.JavaClasesSabados.gestor_productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoriaId(Long categoriaId);
    List<Producto> findByNombreContainingIgnoreCase(String texto);
    //Esta muchas veces puede quedar vacia pero puedo hacer busquedas personalizadas como los anterioees
}
