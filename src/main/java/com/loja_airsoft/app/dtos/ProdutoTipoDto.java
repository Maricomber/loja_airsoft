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
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ProdutoDto> produtoDto;
	
	public ProdutoTipoDto() {
		
	}
	
	public ProdutoTipoDto(ProdutoTipo produtoTipo) {
		this.idProdutoTp = produtoTipo.getIdProdutoTp();
		this.dsProdutoTp = produtoTipo.getDsProdutoTp();
	}
	
	public ProdutoTipo toEntity() {
		ProdutoTipo produtoTipo = new ProdutoTipo();
		produtoTipo.setIdProdutoTp(this.idProdutoTp);
		produtoTipo.setDsProdutoTp(this.dsProdutoTp);
		
		return produtoTipo;
	}
}
