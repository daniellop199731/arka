package com.bancolombia.arka.domain.port.in;

import java.util.List;

import com.bancolombia.arka.domain.model.Proveedor;

public interface ProveedorUseCase {

    List<Proveedor> getAllProveedores();
    Proveedor getProveedorById(int idProveedor);
    Proveedor createProveedor(Proveedor proveedor);
    Proveedor updateProveedor(int idProveedor, Proveedor proveedor);
    boolean deleteProveedorById(int idProveedor);
    
}
