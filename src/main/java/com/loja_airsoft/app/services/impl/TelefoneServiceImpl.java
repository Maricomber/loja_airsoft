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
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(TelefoneServiceImpl.class);
	
	@Override
	public TelefoneDto save(TelefoneDto telefoneDto) throws Exception {
		
		log.info("Salvando telefone");
		Telefone telefone = new Telefone();
		
		if(telefoneDto.equals(null)) {
			throw new Exception("Pesquisa em branco. ");
		}
		try {
			telefone = this.telefoneRepository.save(telefoneDto.toEntity());
			return new TelefoneDto(telefone);
		}catch (Exception e) {
			msgErro = "Erro ao salvar telefone. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public TelefoneDto findById(Integer id_telefone) throws Exception {
		log.info("Buscando telefone.");
		Telefone telefone = new Telefone();
		try {
			telefone = this.telefoneRepository.findByidTelefone(id_telefone);
			if(telefone == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("telefone encontrado.");
			return new TelefoneDto(telefone);
		}catch (Exception e) {
			msgErro = "Erro ao buscar telefone."+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer id_telefone) throws Exception {
		Telefone telefone = new Telefone();
		log.info("Deletando telefone");
		
		try{
			telefone = this.telefoneRepository.findByidTelefone(id_telefone);
			this.telefoneRepository.delete(telefone);
		}catch (Exception e) {
			msgErro = "telefone não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<TelefoneDto> findTelefones() throws Exception {
		log.info("Buscando todos os telefones");
		List<Telefone> telefones = new ArrayList<Telefone>();
		List<TelefoneDto> telefonesDto = new ArrayList<TelefoneDto>();
		
		try {
			telefones = this.telefoneRepository.findAll();
			log.info("Busca realizada com sucesso");
			
			telefones.forEach(telefone -> telefonesDto.add(new TelefoneDto(telefone)));
			return telefonesDto;
		}catch (Exception e) {
			msgErro = "Erro ao buscar telefones. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

}
