package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.PerfilDto;

@Service
public interface PerfilService {

	PerfilDto save(PerfilDto perfilDto) throws Exception;
	
	PerfilDto findById(Integer id_perfil) throws Exception;
	
	Boolean delete(Integer id_perfil) throws Exception;
	
	List<PerfilDto>findPerfils() throws Exception;
}
