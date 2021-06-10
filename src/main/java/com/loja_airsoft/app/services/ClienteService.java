package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.ClienteDto;

@Service
public interface ClienteService {

	ClienteDto save(ClienteDto clienteDto);
	
	ClienteDto findById(Integer cpfCliente);
	
	Boolean delete(ClienteDto clienteDto);
	
	List<ClienteDto>findClientes();
}
