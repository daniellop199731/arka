package com.bancolombia.arka.domain.port.in;

import java.util.List;
import com.bancolombia.arka.domain.model.MetodoPago;

public interface MetodoPagoUseCase {

    List<MetodoPago> getMetodosPago();
    MetodoPago getMetodoPagoById(int idMetodoPago);
    MetodoPago createMetodoPago(MetodoPago metodoPago);
    MetodoPago updateMetodoPago(int idMetodoPago, MetodoPago metodoPago);
    boolean deleteMetodoPagoById(int idMetodoPago);

}

