package com.bancolombia.arka.application.useCase;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bancolombia.arka.application.utils.ResponseObject;
import com.bancolombia.arka.domain.model.MetodoPago;
import com.bancolombia.arka.domain.model.MetodoPagoCliente;
import com.bancolombia.arka.domain.model.Cliente;
import com.bancolombia.arka.domain.port.in.MetodoPagoClienteUseCase;
import com.bancolombia.arka.domain.port.out.MetodoPagoRepositoryPort;
import com.bancolombia.arka.domain.port.out.MetodoPagoClienteRepositoryPort;
import com.bancolombia.arka.domain.port.out.ClienteRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MetodoPagoClienteApplicationService implements MetodoPagoClienteUseCase {

    private final MetodoPagoClienteRepositoryPort metodoPagoClienteRepositoryPort;
    private final MetodoPagoRepositoryPort metodoPagoRepositoryPort;
    private final ClienteRepositoryPort ClienteRepositoryPort;

    private static ResponseObject<MetodoPagoCliente> rObj;

    @Override
    public List<MetodoPagoCliente> getMetodosPagoByIdCliente(int idCliente) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        return metodoPagoClienteRepositoryPort.findByClienteMetodoPago(cliente);
    }

    @Override
    public ResponseObject<MetodoPagoCliente> createMetodoPagoCliente(int idCliente, int idMetodoPago) {
        rObj = new ResponseObject<>();

        if(!ClienteRepositoryPort.existsById(idCliente)){
            rObj.setAsNotSuccessful("No existe el Cliente con id " + idCliente);
            return rObj;
        }

        if(!metodoPagoRepositoryPort.existsById(idMetodoPago)){
            rObj.setAsNotSuccessful("No existe el Metodo de pago con id " + idMetodoPago);
            return rObj;
        }

        if(metodoPagoClienteRepositoryPort.existByIdClienteAndMetodoPago(idCliente, idMetodoPago)){
            rObj.setAsNotSuccessful("Ya existe la asignacion");
            return rObj;
        }

        MetodoPagoCliente metodoPagoCliente = new MetodoPagoCliente();

        Cliente ClienteMetodoPago = new Cliente();
        ClienteMetodoPago.setIdCliente(idCliente);
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setIdMetodoPago(idMetodoPago);

        metodoPagoCliente.setClienteMetodoPago(ClienteMetodoPago);
        metodoPagoCliente.setMetodoPago(metodoPago);

        rObj.setAsSuccessful("Se agrego el metodo de pago al Cliente con exito"
                            , metodoPagoClienteRepositoryPort.save(metodoPagoCliente));

        return rObj;
    }

    @Override
    public ResponseObject<MetodoPagoCliente> manageMetodoPagoCliente(int idCliente, int idMetodoPago,
            double valorCuenta) {

        rObj = new ResponseObject<>();

        if(!metodoPagoRepositoryPort.existsById(idMetodoPago)){
            rObj.setAsNotSuccessful("No existe el Metodo de pago con id " + idMetodoPago);
            return rObj;
        }

        if(!ClienteRepositoryPort.existsById(idCliente)){
            rObj.setAsNotSuccessful("No existe el Cliente con id " + idCliente);
            return rObj;
        }

        if(valorCuenta <= 0){
            rObj.setAsNotSuccessful("El valor a cargar debe ser mayor a cero");
            return rObj;
        }

        MetodoPagoCliente metodoPagoCliente = new MetodoPagoCliente();
        Cliente clienteMetodoPago = new Cliente();
        clienteMetodoPago.setIdCliente(idCliente);
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setIdMetodoPago(idMetodoPago);

        metodoPagoCliente.setClienteMetodoPago(clienteMetodoPago);
        metodoPagoCliente.setMetodoPago(metodoPago);
        metodoPagoCliente.setValorCuentaMetodoPago(valorCuenta);

        Optional<MetodoPagoCliente> metodoPagoClienteFinded = metodoPagoClienteRepositoryPort.findByIdClienteAndIdMetodoPago(idCliente, idMetodoPago);
        String msg = "Se agrego el metodo de pago al Cliente con exito";

        if(metodoPagoClienteFinded.isPresent()){
            metodoPagoCliente.setId(metodoPagoClienteFinded.get().getId());
            metodoPagoCliente.setValorCuentaMetodoPago(metodoPagoClienteFinded.get().getValorCuentaMetodoPago() + valorCuenta);
            msg = "Se realizó la actualizacíon con exíto";
        }

        rObj.setAsSuccessful(msg ,metodoPagoClienteRepositoryPort.save(metodoPagoCliente));
        return rObj;
    }

    @Override
    public boolean deleteByIdClienteAndMetodoPago(int idCliente,
            int idMetodoPago) {
        Optional<MetodoPagoCliente> metodoPagoCliente = metodoPagoClienteRepositoryPort.findByIdClienteAndIdMetodoPago(idCliente, idMetodoPago);
        if(metodoPagoCliente.isPresent()){
            metodoPagoClienteRepositoryPort.deleteById(metodoPagoCliente.get().getId());
            return true;
        }
        return false;
    }

}
