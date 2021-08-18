package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.ProdutoDto;
import com.loja_airsoft.app.entities.Produto;
import com.loja_airsoft.app.repositories.ProdutoRepository;
import com.loja_airsoft.app.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	ProdutoRepository produtoRepository;
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(ProdutoServiceImpl.class);
	
	@Override
	public ProdutoDto save(ProdutoDto produtoDto) throws Exception {
		
		if(produtoDto.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		log.info("Salvando produto");
		Produto produto = new Produto();
		try {
			produto = this.produtoRepository.save(ProdutoDto.toEntity(produtoDto));
			return  ProdutoDto.fromEntity(produto);
		}catch (Exception e) {
			msgErro = "Erro ao salvar produto. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
	

	@Override
	public ProdutoDto findById(Integer id_produto) throws Exception {
		log.info("Buscando produto.");
		Produto produto = new Produto();
		try {
			produto = this.produtoRepository.findByIdProduto(id_produto);
			if(produto == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("Produto encontrado.");
			return ProdutoDto.fromEntity(produto);
		}catch (Exception e) {
			msgErro = "Erro ao buscar produto. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer id_produto) throws Exception {
		
		Produto produto = new Produto();
		log.info("Deletando produto ");
		
		try{
			produto = this.produtoRepository.findByIdProduto(id_produto);
			this.produtoRepository.delete(produto);
		}catch (Exception e) {;
			msgErro = "Erro produto não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<ProdutoDto> findProdutos() throws Exception {
		log.info("Buscando todos os produtos");
		List<Produto> produtos = new ArrayList<Produto>();
		List<ProdutoDto> produtosRetorno = new ArrayList<ProdutoDto>();
		
		try {
			produtos = this.produtoRepository.findAll();
			for(Produto produto: produtos) {
				produtosRetorno.add(ProdutoDto.fromEntity(produto));
			}
			log.info("Busca realizada com sucesso");
			return produtosRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar produtos. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
}