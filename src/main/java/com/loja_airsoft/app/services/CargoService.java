package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.CargoDto;

@Service
public interface CargoService {

	CargoDto save(CargoDto cargoDto) throws Exception;
	
	CargoDto findById(Integer id_cargo) throws Exception;
	
	Boolean delete(Integer id_cargo) throws Exception;
	
	List<CargoDto>findCargos() throws Exception;
	
}
