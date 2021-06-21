package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.FabricanteDto;

@Service
public interface FabricanteService {

	FabricanteDto save(FabricanteDto fabricanteDto) throws Exception;
	
	FabricanteDto findById(Integer id_fabricante) throws Exception;
	
	Boolean delete(Integer id_fabricante) throws Exception;
	
	List<FabricanteDto>findFabricantes() throws Exception;
	
}
