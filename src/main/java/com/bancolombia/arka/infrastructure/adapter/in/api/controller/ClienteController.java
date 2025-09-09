package com.bancolombia.arka.infrastructure.adapter.in.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.arka.domain.model.Cliente;
import com.bancolombia.arka.domain.port.in.ClienteUserCase;
import com.bancolombia.arka.infrastructure.adapter.in.api.dto.ClienteDto;
import com.bancolombia.arka.infrastructure.adapter.in.api.mapper.ClienteWebMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteUserCase ClienteUserCase;
    private final ClienteWebMapper mapper;

    @GetMapping("")
    public ResponseEntity<List<ClienteDto>> getAllClientes() {
        List<Cliente> Clientes = ClienteUserCase.getAllClientes();
        List<ClienteDto> ClienteDtos = Clientes.stream()
            .map(mapper::toDto)
            .toList();
        return ResponseEntity.ok(ClienteDtos);
    }
    
    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable("idCliente") int idCliente) {
        Cliente Cliente = ClienteUserCase.getClienteById(idCliente);
        return ResponseEntity.ok(mapper.toDto(Cliente));
    }

    @PostMapping("/createCliente")
    public ResponseEntity<ClienteDto> createCliente(@Valid @RequestBody ClienteDto clienteDto) {
        Cliente clienteCreated = ClienteUserCase.createCliente(mapper.toModel(clienteDto));
        return ResponseEntity.ok(mapper.toDto(clienteCreated));
    }

    @PutMapping("/updateCliente/{idCliente}")
    public ResponseEntity<ClienteDto> putMethodName(@PathVariable("idCliente") int idCliente, @RequestBody ClienteDto clienteDto) {
        Cliente cliente = mapper.toModel(clienteDto);
        Cliente clienteUpdated = ClienteUserCase.updateCliente(idCliente, cliente);
        return ResponseEntity.ok(mapper.toDto(clienteUpdated));
    }

    @DeleteMapping("/deleteCliente/{idCliente}")
    public ResponseEntity<Void> deleteUsaurio(@PathVariable("idCliente") int idCliente){
        if(ClienteUserCase.deleteCliente(idCliente)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    

}

