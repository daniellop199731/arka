package com.bancolombia.arka.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.bancolombia.arka.domain.model.MetodoPagoCliente;
import com.bancolombia.arka.domain.model.Cliente;

public interface MetodoPagoClienteRepositoryPort {

    List<MetodoPagoCliente> findByClienteMetodoPago(Cliente cliente);
    Optional<MetodoPagoCliente> findByIdClienteAndIdMetodoPago(int idClienteMetodoPago, int idMetodoPago);
    MetodoPagoCliente save(MetodoPagoCliente metodoPagoCliente);
    boolean existByIdClienteAndMetodoPago(int idClienteMetodoPago, int idMetodoPago);
    void deleteById(int idMetodoPagoCliente);

}
