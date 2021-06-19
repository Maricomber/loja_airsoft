package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.EnderecoDto;

@Service
public interface EnderecoService {

	EnderecoDto save(EnderecoDto enderecoDto);
	
	EnderecoDto findById(Integer idEndereco);
	
	Boolean delete(EnderecoDto enderecoDto);
	
	List<EnderecoDto>findEnderecos();
}
