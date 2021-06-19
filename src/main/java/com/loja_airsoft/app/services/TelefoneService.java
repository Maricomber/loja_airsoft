package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.TelefoneDto;

@Service
public interface TelefoneService {

	TelefoneDto save(TelefoneDto telefoneDto) throws Exception;
	
	TelefoneDto findById(Integer idTelefone) throws Exception;
	
	Boolean delete(Integer idTelefone) throws Exception;
	
	List<TelefoneDto>findTelefones() throws Exception;
}
