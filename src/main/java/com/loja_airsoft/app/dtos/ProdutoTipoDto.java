package com.loja_airsoft.app.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.Produto;
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
	
	public static ProdutoTipoDto fromEntity(ProdutoTipo produtoTipo) {
		return fromEntity(produtoTipo, false);
	}
	
	public static ProdutoTipoDto fromEntity(ProdutoTipo produtoTipo, Boolean isProduto) {
		List<ProdutoDto> lstProdutoDto = new ArrayList<ProdutoDto>();
		
		ProdutoTipoDto produtoTipoDto = new ProdutoTipoDto();
		produtoTipoDto.setIdProdutoTp(produtoTipo.getIdProdutoTp());
		produtoTipoDto.setDsProdutoTp(produtoTipo.getDsProdutoTp());
		
		if (isProduto) {
			if(produtoTipo.getProduto() != null) {
				for(Produto produto : produtoTipo.getProduto()) {
					lstProdutoDto.add(ProdutoDto.fromEntity(produto, false));
				}
			}
			produtoTipoDto.setProdutoDto(lstProdutoDto);
		}
		
		return produtoTipoDto;
	}
	
	public static ProdutoTipo toEntity (ProdutoTipoDto produtoTipoDto) {
		return toEntity(produtoTipoDto, false);
	}
	
	public static ProdutoTipo toEntity (ProdutoTipoDto produtoTipoDto, Boolean isProduto) {
		List<Produto> lstProduto = new ArrayList<Produto>();
		ProdutoTipo produtoTipo = new ProdutoTipo();
		produtoTipo.setIdProdutoTp(produtoTipoDto.getIdProdutoTp());
		produtoTipo.setDsProdutoTp(produtoTipoDto.getDsProdutoTp());
		
		if(isProduto) {
			if(produtoTipoDto.getProdutoDto() != null) {
				for(ProdutoDto produtoDto : produtoTipoDto.getProdutoDto()) {
					lstProduto.add(ProdutoDto.toEntity(produtoDto, false));
				}
			}
		}
		
		return produtoTipo;
	}
}
