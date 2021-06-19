package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.EnderecoDto;

@Service
public interface EnderecoService {

	EnderecoDto save(EnderecoDto enderecoDto) throws Exception;
	
	EnderecoDto findById(Integer idEndereco) throws Exception;
	
	Boolean delete(Integer idEndereco) throws Exception;
	
	List<EnderecoDto>findEnderecos() throws Exception;
}
