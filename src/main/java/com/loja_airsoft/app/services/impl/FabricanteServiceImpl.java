package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.FabricanteDto;
import com.loja_airsoft.app.entities.Fabricante;
import com.loja_airsoft.app.repositories.FabricanteRepository;
import com.loja_airsoft.app.services.FabricanteService;

@Service
public class FabricanteServiceImpl implements FabricanteService{

	@Autowired
	FabricanteRepository fabricanteRepository;
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(FabricanteServiceImpl.class);
	
	@Override
	public FabricanteDto save(FabricanteDto fabricanteDto) throws Exception {
		
		if(fabricanteDto.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		log.info("Salvando fabricante");
		Fabricante fabricante = new Fabricante();
		try {
			fabricante = this.fabricanteRepository.save(FabricanteDto.toEntity(fabricanteDto));
			return  FabricanteDto.fromEntity(fabricante);
		}catch (Exception e) {
			msgErro = "Erro ao salvar fabricante. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
	

	@Override
	public FabricanteDto findById(Integer id_fabricante) throws Exception {
		log.info("Buscando fabricante.");
		Fabricante fabricante = new Fabricante();
		try {
			fabricante = this.fabricanteRepository.findByIdFabricante(id_fabricante);
			if(fabricante == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("Fabricante encontrado.");
			return FabricanteDto.fromEntity(fabricante);
		}catch (Exception e) {
			msgErro = "Erro ao buscar fabricante. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer id_fabricante) throws Exception {
		
		Fabricante fabricante = new Fabricante();
		log.info("Deletando fabricante ");
		
		try{
			fabricante = this.fabricanteRepository.findByIdFabricante(id_fabricante);
			this.fabricanteRepository.delete(fabricante);
		}catch (Exception e) {;
			msgErro = "Erro fabricante não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<FabricanteDto> findFabricantes() throws Exception {
		log.info("Buscando todos os fabricantes");
		List<Fabricante> fabricantes = new ArrayList<Fabricante>();
		List<FabricanteDto> fabricantesRetorno = new ArrayList<FabricanteDto>();
		
		try {
			fabricantes = this.fabricanteRepository.findAll();
			for(Fabricante fabricante: fabricantes) {
				fabricantesRetorno.add(FabricanteDto.fromEntity(fabricante));
			}
			log.info("Busca realizada com sucesso");
			return fabricantesRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar fabricantes. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
}

