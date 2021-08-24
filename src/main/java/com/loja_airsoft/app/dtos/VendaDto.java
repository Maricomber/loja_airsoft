package com.loja_airsoft.app.dtos;

import java.util.Date;
import java.util.List;

import com.loja_airsoft.app.entities.Venda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendaDto {

	public Integer idVenda;
	public Date dtVenda;
	private Float vlDesconto;
	private Float vlTotal;
	public UsuarioDto cliente;
	public UsuarioDto vendedor;
	public List<ProdutoDto> produtoDto;
	
	public VendaDto() {
		
	}
	
	public VendaDto(Venda venda) {
		this.idVenda = venda.getIdVenda();
		this.dtVenda = venda.getDtVenda();
		this.vlDesconto = venda.getVlDesconto();
		this.vlTotal = venda.getVlTotal();
		venda.getCliente().setVenda(null);
		this.cliente = new UsuarioDto(venda.getCliente());
		this.vendedor = new UsuarioDto(venda.getVendedor());
		venda.getProduto().forEach(produto-> this.produtoDto.add(
				new ProdutoDto(produto)));
	}
	
}
