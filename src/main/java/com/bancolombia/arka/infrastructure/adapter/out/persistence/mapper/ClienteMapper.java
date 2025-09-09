package com.bancolombia.arka.infrastructure.adapter.out.persistence.mapper;

import org.springframework.stereotype.Component;

import com.bancolombia.arka.domain.model.Cliente;
import com.bancolombia.arka.infrastructure.adapter.out.persistence.entity.ClienteEntity;

@Component
public class ClienteMapper {

    public Cliente toModel(ClienteEntity clienteEntity) {
        if (clienteEntity == null) {
            return null;
        }
        Cliente Cliente = new Cliente();
        Cliente.setIdCliente(clienteEntity.getIdCliente());
        Cliente.setIdentificacionCliente(clienteEntity.getIdentificacionCliente());
        Cliente.setCorreoElectronicoCliente(clienteEntity.getCorreoElectronicoCliente());
        Cliente.setNombresCliente(clienteEntity.getNombresCliente());
        Cliente.setApellidosCliente(clienteEntity.getApellidosCliente());
        Cliente.setDireccionDespachoCliente(clienteEntity.getDireccionDespachoCliente());
        Cliente.setNicknameCliente(clienteEntity.getNicknameCliente());
        Cliente.setPerfil(new PerfilMapper().toDomain(clienteEntity.getPerfil()));
        return Cliente;
    }

    public ClienteEntity toEntity(Cliente Cliente) {
        if (Cliente == null) {
            return null;
        }
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setIdCliente(Cliente.getIdCliente());
        clienteEntity.setIdentificacionCliente(Cliente.getIdentificacionCliente());
        clienteEntity.setCorreoElectronicoCliente(Cliente.getCorreoElectronicoCliente());
        clienteEntity.setNombresCliente(Cliente.getNombresCliente());
        clienteEntity.setApellidosCliente(Cliente.getApellidosCliente());
        clienteEntity.setDireccionDespachoCliente(Cliente.getDireccionDespachoCliente());
        clienteEntity.setNicknameCliente(Cliente.getNicknameCliente());
        clienteEntity.setPerfil(new PerfilMapper().toEntity(Cliente.getPerfil()));
        return clienteEntity;
    }

}

