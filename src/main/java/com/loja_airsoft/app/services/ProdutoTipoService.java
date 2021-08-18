package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.ProdutoTipoDto;

@Service
public interface ProdutoTipoService {

	ProdutoTipoDto save(ProdutoTipoDto produtoTipoDto) throws Exception;
	
	ProdutoTipoDto findById(Integer id_produto_tipo) throws Exception;
	
	Boolean delete(Integer id_produto_tipo) throws Exception;
	
	List<ProdutoTipoDto>findProdutoTipos() throws Exception;
	
}
