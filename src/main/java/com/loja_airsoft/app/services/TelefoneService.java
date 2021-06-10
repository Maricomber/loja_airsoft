package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.TelefoneDto;

@Service
public interface TelefoneService {

	TelefoneDto save(TelefoneDto telefoneDto);
	
	TelefoneDto findById(Integer idTelefone);
	
	Boolean delete(TelefoneDto TelefoneDto);
	
	List<TelefoneDto>findTelefones();
}
