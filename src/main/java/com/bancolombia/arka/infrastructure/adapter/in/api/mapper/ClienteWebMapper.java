package com.bancolombia.arka.infrastructure.adapter.in.api.mapper;

import org.springframework.stereotype.Component;

import com.bancolombia.arka.domain.model.Cliente;
import com.bancolombia.arka.infrastructure.adapter.in.api.dto.ClienteDto;

@Component
public class ClienteWebMapper {

    public ClienteDto toDto(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setIdCliente(cliente.getIdCliente());
        clienteDto.setIdentificacionCliente(cliente.getIdentificacionCliente());
        clienteDto.setCorreoElectronicoCliente(cliente.getCorreoElectronicoCliente());
        clienteDto.setNombresCliente(cliente.getNombresCliente());
        clienteDto.setApellidosCliente(cliente.getApellidosCliente());
        clienteDto.setDireccionDespachoCliente(cliente.getDireccionDespachoCliente());
        clienteDto.setNicknameCliente(cliente.getNicknameCliente());
        clienteDto.setPerfil(new PerfilWebMapper().toDto(cliente.getPerfil()));
        return clienteDto;
    }

    public Cliente toModel(ClienteDto ClienteDto) {
        if (ClienteDto == null) {
            return null;
        }
        Cliente Cliente = new Cliente();
        Cliente.setIdCliente(ClienteDto.getIdCliente());
        Cliente.setIdentificacionCliente(ClienteDto.getIdentificacionCliente());
        Cliente.setCorreoElectronicoCliente(ClienteDto.getCorreoElectronicoCliente());
        Cliente.setNombresCliente(ClienteDto.getNombresCliente());
        Cliente.setApellidosCliente(ClienteDto.getApellidosCliente());
        Cliente.setDireccionDespachoCliente(ClienteDto.getDireccionDespachoCliente());
        Cliente.setNicknameCliente(ClienteDto.getNicknameCliente());
        Cliente.setPerfil(new PerfilWebMapper().toModel(ClienteDto.getPerfil()));
        return Cliente;
    }

}

