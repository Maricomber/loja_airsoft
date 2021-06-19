package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.ClienteDto;

@Service
public interface ClienteService {

	ClienteDto save(ClienteDto clienteDto) throws Exception;
	
	ClienteDto findById(Integer idCliente) throws Exception;
	
	Boolean delete(Integer idCliente) throws Exception;
	
	List<ClienteDto>findClientes() throws Exception;
	
}
