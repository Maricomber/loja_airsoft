package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.ProdutoTipoDto;
import com.loja_airsoft.app.entities.ProdutoTipo;
import com.loja_airsoft.app.repositories.ProdutoTipoRepository;
import com.loja_airsoft.app.services.ProdutoTipoService;

@Service
public class ProdutoTipoServiceImpl implements ProdutoTipoService{

	@Autowired
	ProdutoTipoRepository produtoTipoRepository;
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(ProdutoTipoServiceImpl.class);
	
	@Override
	public ProdutoTipoDto save(ProdutoTipoDto produtoTipoDto) throws Exception {
		
		if(produtoTipoDto.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		log.info("Salvando produtoTipo");
		ProdutoTipo produtoTipo = new ProdutoTipo();
		try {
			produtoTipo = this.produtoTipoRepository.save(produtoTipoDto.toEntity());
			return new ProdutoTipoDto(produtoTipo);
		}catch (Exception e) {
			msgErro = "Erro ao salvar produtoTipo. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
	

	@Override
	public ProdutoTipoDto findById(Integer id_produtoTipo) throws Exception {
		log.info("Buscando produtoTipo.");
		ProdutoTipo produtoTipo = new ProdutoTipo();
		try {
			produtoTipo = this.produtoTipoRepository.findByIdProdutoTp(id_produtoTipo);
			if(produtoTipo == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("ProdutoTipo encontrado.");
			return new ProdutoTipoDto(produtoTipo);
		}catch (Exception e) {
			msgErro = "Erro ao buscar produtoTipo. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer id_produtoTipo) throws Exception {
		
		ProdutoTipo produtoTipo = new ProdutoTipo();
		log.info("Deletando produtoTipo ");
		
		try{
			produtoTipo = this.produtoTipoRepository.findByIdProdutoTp(id_produtoTipo);
			this.produtoTipoRepository.delete(produtoTipo);
		}catch (Exception e) {;
			msgErro = "Erro produtoTipo não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<ProdutoTipoDto> findProdutoTipos() throws Exception {
		log.info("Buscando todos os produtoTipos");
		List<ProdutoTipo> produtoTipos = new ArrayList<ProdutoTipo>();
		List<ProdutoTipoDto> produtoTiposRetorno = new ArrayList<ProdutoTipoDto>();
		
		try {
			produtoTipos = this.produtoTipoRepository.findAll();
			for(ProdutoTipo produtoTipo: produtoTipos) {
				produtoTiposRetorno.add(new ProdutoTipoDto(produtoTipo));
			}
			log.info("Busca realizada com sucesso");
			return produtoTiposRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar produtoTipos. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
}