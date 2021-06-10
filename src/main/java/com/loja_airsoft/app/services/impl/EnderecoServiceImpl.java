package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.EnderecoDto;
import com.loja_airsoft.app.entities.Endereco;
import com.loja_airsoft.app.repositories.EnderecoRepository;
import com.loja_airsoft.app.services.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{

	@Autowired
	EnderecoRepository enderecoRepository;
	
	private static final Logger log = LoggerFactory.getLogger(EnderecoServiceImpl.class);
	
	@Override
	public EnderecoDto save(EnderecoDto enderecoDto) {
		log.info("Salvando endereco");
		Endereco endereco = new Endereco();
		try {
			endereco = this.enderecoRepository.save(EnderecoDto.toEntity(enderecoDto));
			return  EnderecoDto.fromEntity(endereco);
		}catch (Exception e) {
			log.info("Erro ao salvar endereco");
			return null;
		}
	}

	@Override
	public EnderecoDto findById(Integer id_endereco) {
		log.info("Buscando endereco.");
		Endereco endereco = new Endereco();
		try {
			endereco = this.enderecoRepository.findByidEndereco(id_endereco);
			if(endereco == null) {
				log.info("Sem resultados.");
				return null;
			}
			log.info("endereco encontrado.");
			return EnderecoDto.fromEntity(endereco);
		}catch (Exception e) {
			log.info("Erro ao buscar endereco.");
			return null;
		}
	}

	@Override
	public Boolean delete(EnderecoDto enderecoDto) {
		log.info("Deletando endereco");
		try{
			this.enderecoRepository.delete(EnderecoDto.toEntity(enderecoDto));
			return true;
		}catch (Exception e) {
			log.info("endereco não pode ser deletado");
		}
		return false;
	}

	@Override
	public List<EnderecoDto> findEnderecos() {
		log.info("Buscando todos os enderecos");
		List<Endereco> enderecos = new ArrayList<Endereco>();
		List<EnderecoDto> enderecosRetorno = new ArrayList<EnderecoDto>();
		
		try {
			enderecos = this.enderecoRepository.findAll();
			for(Endereco endereco: enderecos) {
				enderecosRetorno.add(EnderecoDto.fromEntity(endereco));
			}
			log.info("Busca realizada com sucesso");
			return enderecosRetorno;
		}catch (Exception e) {
			log.info("Erro ao buscar enderecos");
			return null;
		}
	}

}
