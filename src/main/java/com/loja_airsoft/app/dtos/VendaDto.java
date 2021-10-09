package com.loja_airsoft.app.dtos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.Venda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendaDto {

	public Integer idVenda;
	public String dtVenda;
	private Float vlDesconto;
	private Float vlTotal;
	private int qtd;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	public UsuarioDto cliente;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	public UsuarioDto vendedor;
	
	public List<ProdutoDto> produtoDto = new ArrayList<ProdutoDto>();
	
	public VendaDto() {
		
	}
	
	public VendaDto(Venda venda) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.idVenda = venda.getIdVenda();
		this.dtVenda = dateFormat.format(venda.getDtVenda());
		this.vlDesconto = venda.getVlDesconto();
		this.vlTotal = venda.getVlTotal();
		this.cliente = new UsuarioDto(venda.getCliente());
		this.vendedor = new UsuarioDto(venda.getVendedor());
		venda.getProduto().forEach(produto-> this.produtoDto.add(
				new ProdutoDto(produto)));
		this.qtd = this.produtoDto.size();
	}
	
}
