package com.JavaClasesSabados.gestor_productos.repository;

import com.JavaClasesSabados.gestor_productos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
