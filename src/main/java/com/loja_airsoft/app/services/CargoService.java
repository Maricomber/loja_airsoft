package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.CargoDto;

@Service
public interface CargoService {

	CargoDto save(CargoDto cargoDto) throws Exception;
	
	List<CargoDto> findByCargo(CargoDto cargoDto) throws Exception;
	
	Boolean delete(CargoDto cargoDto) throws Exception;
	
	List<CargoDto>findCargos() throws Exception;
	
}
