package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.ClienteDto;

@Service
public interface ClienteService {

	ClienteDto save(ClienteDto clienteDto) throws Exception;
	
	ClienteDto findById(Integer cpfCliente) throws Exception;
	
	Boolean delete(ClienteDto clienteDto) throws Exception;
	
	List<ClienteDto>findClientes();
	
	ClienteDto update(ClienteDto clienteDto) throws Exception;
}
