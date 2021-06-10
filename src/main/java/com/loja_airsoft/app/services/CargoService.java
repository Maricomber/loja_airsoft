package com.loja_airsoft.app.services;

import java.util.List;

import com.loja_airsoft.app.dtos.CargoDto;

public interface CargoService {

	CargoDto save(CargoDto cargoDto);
	
	CargoDto findById(Integer id_cargo);
	
	Boolean delete(CargoDto cargoDto);
	
	List<CargoDto>findCargos();
	
}
