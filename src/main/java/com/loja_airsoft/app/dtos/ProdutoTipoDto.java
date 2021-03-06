package com.loja_airsoft.app.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.ProdutoTipo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoTipoDto {

	private int idProdutoTp;
	private String dsProdutoTp;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<ProdutoDto> produtoDto;
	
	public ProdutoTipoDto() {
		
	}
	
	public ProdutoTipoDto(ProdutoTipo produtoTipo) {
		this.idProdutoTp = produtoTipo.getIdProdutoTp();
		this.dsProdutoTp = produtoTipo.getDsProdutoTp();
	}
	
}
