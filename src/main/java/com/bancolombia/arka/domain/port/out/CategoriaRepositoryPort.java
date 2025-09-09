package com.bancolombia.arka.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.bancolombia.arka.domain.model.Categoria;

public interface CategoriaRepositoryPort {

    List<Categoria> findAll();
    Optional<Categoria> findById(int idCategoria);
    Categoria save(Categoria categoria);
    void deleteById(int idCategoria);
    boolean existsById(int idCategoria);
}
