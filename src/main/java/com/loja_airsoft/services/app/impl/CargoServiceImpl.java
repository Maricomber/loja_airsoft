package com.loja_airsoft.services.app.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.entities.Cargo;
import com.loja_airsoft.app.repositories.CargoRepository;
import com.loja_airsoft.app.dtos.CargoDto;
import com.loja_airsoft.app.services.CargoService;

@Service
public class CargoServiceImpl implements CargoService{

	Cargo cargo = new Cargo();
	CargoRepository cargoRepository;
	
	private static final Logger log = LoggerFactory.getLogger(CargoServiceImpl.class);
	
	@Override
	public CargoDto save(CargoDto cargoDto) {
		log.info("Salvando cargo");

		try {
			cargo = this.cargoRepository.save(CargoDto.toEntity(cargoDto));
			return  CargoDto.fromEntity(cargo);
		}catch (Exception e) {
			log.info("Erro ao salvar cargo");
			return null;
		}
	}
	
	

	@Override
	public CargoDto findById(Integer id_cargo) {
		log.info("Buscando cargo.");
		Cargo cargo = new Cargo();
		try {
			cargo = this.cargoRepository.findByIdCargo(id_cargo);
			if(cargo == null) {
				log.info("Sem resultados.");
				return null;
			}
			log.info("Cargo encontrado.");
			return CargoDto.fromEntity(cargo);
		}catch (Exception e) {
			log.info("Erro ao buscar cargo.");
			return null;
		}
	}

	@Override
	public Boolean delete(CargoDto cargoDto) {
		log.info("Deletando cargo");
		try{
			this.cargoRepository.delete(CargoDto.toEntity(cargoDto));
			return true;
		}catch (Exception e) {
			log.info("Cargo não pode ser deletado");
		}
		return false;
	}

	@Override
	public List<CargoDto> findCargos() {
		log.info("Buscando todos os cargos");
		List<Cargo> cargos = new ArrayList<Cargo>();
		List<CargoDto> cargosRetorno = new ArrayList<CargoDto>();
		
		try {
			cargos = this.cargoRepository.findAll();
			for(Cargo cargo: cargos) {
				cargosRetorno.add(CargoDto.fromEntity(cargo));
			}
			log.info("Busca realizada com sucesso");
			return cargosRetorno;
		}catch (Exception e) {
			log.info("Erro ao buscar cargos");
			return null;
		}
	}
}
