package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.entities.Cargo;
import com.loja_airsoft.app.repositories.CargoRepository;
import com.loja_airsoft.app.dtos.CargoDto;
import com.loja_airsoft.app.services.CargoService;

@Service
public class CargoServiceImpl implements CargoService{
	
	@Autowired
	CargoRepository cargoRepository;
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(CargoServiceImpl.class);
	
	@Override
	public CargoDto save(CargoDto cargoDto) throws Exception {
		
		if(cargoDto.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		log.info("Salvando cargo");
		Cargo cargo = new Cargo();
		try {
			cargo = this.cargoRepository.save(cargoDto.toEntity());
			return new CargoDto(cargo);
		}catch (Exception e) {
			msgErro = "Erro ao salvar cargo. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
	

	@Override
	public CargoDto findById(Integer id_cargo) throws Exception {
		log.info("Buscando cargo.");
		Cargo cargo = new Cargo();
		try {
			cargo = this.cargoRepository.findByIdCargo(id_cargo);
			if(cargo == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("Cargo encontrado.");
			return new CargoDto(cargo);
		}catch (Exception e) {
			msgErro = "Erro ao buscar cargo. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer id_cargo) throws Exception {
		
		Cargo cargo = new Cargo();
		log.info("Deletando cargo ");
		
		try{
			cargo = this.cargoRepository.findByIdCargo(id_cargo);
			this.cargoRepository.delete(cargo);
		}catch (Exception e) {;
			msgErro = "Erro cargo não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<CargoDto> findCargos() throws Exception {
		log.info("Buscando todos os cargos");
		List<Cargo> cargos = new ArrayList<Cargo>();
		List<CargoDto> cargosRetorno = new ArrayList<CargoDto>();
		
		try {
			cargos = this.cargoRepository.findAll();
			for(Cargo cargo: cargos) {
				cargosRetorno.add(new CargoDto(cargo));
			}
			log.info("Busca realizada com sucesso");
			return cargosRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar cargos. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
}
