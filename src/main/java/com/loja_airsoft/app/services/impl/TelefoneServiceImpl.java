package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.TelefoneDto;
import com.loja_airsoft.app.entities.Telefone;
import com.loja_airsoft.app.repositories.TelefoneRepository;
import com.loja_airsoft.app.services.TelefoneService;

@Service
public class TelefoneServiceImpl implements TelefoneService{

	@Autowired
	TelefoneRepository telefoneRepository;
	
	private static final Logger log = LoggerFactory.getLogger(CargoServiceImpl.class);
	
	@Override
	public TelefoneDto save(TelefoneDto telefoneDto) {
		log.info("Salvando telefone");
		Telefone telefone = new Telefone();
		try {
			telefone = this.telefoneRepository.save(TelefoneDto.toEntity(telefoneDto));
			return  TelefoneDto.fromEntity(telefone);
		}catch (Exception e) {
			log.info("Erro ao salvar telefone");
			return null;
		}
	}

	@Override
	public TelefoneDto findById(Integer id_telefone) {
		log.info("Buscando telefone.");
		Telefone telefone = new Telefone();
		try {
			telefone = this.telefoneRepository.findByidTelefone(id_telefone);
			if(telefone == null) {
				log.info("Sem resultados.");
				return null;
			}
			log.info("telefone encontrado.");
			return TelefoneDto.fromEntity(telefone);
		}catch (Exception e) {
			log.info("Erro ao buscar telefone.");
			return null;
		}
	}

	@Override
	public Boolean delete(TelefoneDto telefoneDto) {
		log.info("Deletando telefone");
		try{
			this.telefoneRepository.delete(TelefoneDto.toEntity(telefoneDto));
			return true;
		}catch (Exception e) {
			log.info("telefone não pode ser deletado");
		}
		return false;
	}

	@Override
	public List<TelefoneDto> findTelefones() {
		log.info("Buscando todos os telefones");
		List<Telefone> telefones = new ArrayList<Telefone>();
		
		try {
			telefones = this.telefoneRepository.findAll();
			log.info("Busca realizada com sucesso");
			return TelefoneDto.fromEntity(telefones);
		}catch (Exception e) {
			log.info("Erro ao buscar telefones");
			return null;
		}
	}

}
