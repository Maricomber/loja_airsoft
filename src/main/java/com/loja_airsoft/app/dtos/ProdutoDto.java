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
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private VendaDto vendaDto;
	
	public ProdutoDto() {
		
	}
	
	public ProdutoDto(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.dsProduto = produto.getDsProduto();
		this.vlPreco = produto.getVlPreco();
		this.fabricanteDto = new FabricanteDto(produto.getFabricante());
		this.produtoTipoDto = new ProdutoTipoDto(produto.getProdutoTipo());
		this.vendaDto = new VendaDto(produto.getVenda());
	}
	
	public Produto toEntity() {
		Produto produto = new Produto();
		produto.setIdProduto(this.idProduto);
		produto.setDsProduto(this.dsProduto);
		produto.setVlPreco(this.vlPreco);
		produto.setFabricante(this.fabricanteDto.toEntity());
		produto.setProdutoTipo(this.produtoTipoDto.toEntity());
		produto.setVenda(this.vendaDto.toEntity());
		
		return produto;
	}
}
