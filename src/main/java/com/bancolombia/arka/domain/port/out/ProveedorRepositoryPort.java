package com.bancolombia.arka.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.bancolombia.arka.domain.model.Proveedor;

public interface ProveedorRepositoryPort {

    List<Proveedor> findAll();
    Optional<Proveedor> findById(int idProveedor);
    Proveedor save(Proveedor proveedor);
    void deleteById(int idProveedor);
    boolean existsById(int idProveedor);

}
