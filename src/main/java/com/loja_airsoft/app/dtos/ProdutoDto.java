package com.loja_airsoft.app.dtos;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.Produto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {

	private int idProduto;
	private String dsProduto;
	private float vlPreco;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private FabricanteDto fabricanteDto;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ProdutoTipoDto produtoTipoDto;
	
	public static ProdutoDto fromEntity(Produto produto) {
		return fromEntity(produto, true);
	}
	
	public static ProdutoDto fromEntity(Produto produto, Boolean isProduto) {
		ProdutoDto produtoDto = new ProdutoDto();
		produtoDto.setIdProduto(produto.getIdProduto());
		produtoDto.setDsProduto(produto.getDsProduto());
		produtoDto.setVlPreco(produto.getVlPreco());
		
		if(isProduto) {
			produtoDto.setFabricanteDto(FabricanteDto.fromEntity(produto.getFabricante(), false));
			produtoDto.setProdutoTipoDto(ProdutoTipoDto.fromEntity(produto.getProdutoTipo(), false));
		}
		return produtoDto;
	}
	
	public static Produto toEntity(ProdutoDto produtoDto) {
		return toEntity(produtoDto, true);
	}
	
	public static Produto toEntity(ProdutoDto produtoDto, Boolean isProduto) {
		Produto produto = new Produto();
		produto.setIdProduto(produtoDto.getIdProduto());
		produto.setDsProduto(produtoDto.getDsProduto());
		produto.setVlPreco(produtoDto.getVlPreco());
		
		if(isProduto) {
			produto.setFabricante(FabricanteDto.toEntity(produtoDto.getFabricanteDto(), false));
			produto.setProdutoTipo(ProdutoTipoDto.toEntity(produtoDto.getProdutoTipoDto(), false));
		}
		return produto;
	}
}
