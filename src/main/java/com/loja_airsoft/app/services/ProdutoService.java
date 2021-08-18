package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.ProdutoDto;

@Service
public interface ProdutoService {

	ProdutoDto save(ProdutoDto produtoDto) throws Exception;
	
	ProdutoDto findById(Integer id_produto) throws Exception;
	
	Boolean delete(Integer id_produto) throws Exception;
	
	List<ProdutoDto>findProdutos() throws Exception;
	
}
