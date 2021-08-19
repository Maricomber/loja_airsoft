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
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(EnderecoServiceImpl.class);
	
	@Override
	public EnderecoDto save(EnderecoDto enderecoDto) throws Exception {
		log.info("Salvando endereco");
		Endereco endereco = new Endereco();
		
		if(enderecoDto.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		
		try {
			endereco = enderecoDto.toEntity();
			endereco.getCliente().setEndereco(endereco);

			return  new EnderecoDto(this.enderecoRepository.save(endereco));
		}catch (Exception e) {
			msgErro = "Erro ao salvar endereço. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public EnderecoDto findById(Integer id_endereco) throws Exception {
		log.info("Buscando endereco.");
		Endereco endereco = new Endereco();
		try {
			endereco = this.enderecoRepository.findByidEndereco(id_endereco);
			if(endereco == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("endereco encontrado.");
			return new EnderecoDto(endereco);
		}catch (Exception e) {
			msgErro = "Erro ao buscar endereço. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer id_endereco) throws Exception {
		log.info("Deletando endereco");
		Endereco endereco = new Endereco();
		
		try{
			endereco = this.enderecoRepository.findByidEndereco(id_endereco);
			this.enderecoRepository.delete(endereco);
		}catch (Exception e) {
			msgErro = "Endereco não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<EnderecoDto> findEnderecos() throws Exception {
		log.info("Buscando todos os enderecos");
		List<Endereco> enderecos = new ArrayList<Endereco>();
		List<EnderecoDto> enderecosRetorno = new ArrayList<EnderecoDto>();
		
		try {
			enderecos = this.enderecoRepository.findAll();
			for(Endereco endereco: enderecos) {
				enderecosRetorno.add(new EnderecoDto(endereco));
			}
			log.info("Busca realizada com sucesso");
			return enderecosRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar enderecos. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

}
