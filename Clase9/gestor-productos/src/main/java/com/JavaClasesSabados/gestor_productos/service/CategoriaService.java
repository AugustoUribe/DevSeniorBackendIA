package com.JavaClasesSabados.gestor_productos.service;

import com.JavaClasesSabados.gestor_productos.model.Categoria;
import com.JavaClasesSabados.gestor_productos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}

