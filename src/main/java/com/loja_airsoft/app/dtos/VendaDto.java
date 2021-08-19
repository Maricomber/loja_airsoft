package com.loja_airsoft.app.dtos;

import java.util.Date;

import com.loja_airsoft.app.entities.Venda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendaDto {

	public Integer idVenda;
	public Date dtVenda;
	public ProdutoDto produto;
	public ClienteDto cliente;
	public FuncionarioDto funcionario;
	
	public VendaDto(Venda venda) {
		this.idVenda = venda.getIdVenda();
		this.dtVenda = venda.getDtVenda();
		this.produto = new ProdutoDto(venda.getProduto());
		this.cliente = new ClienteDto(venda.getCliente());
		this.funcionario = new FuncionarioDto(venda.getFuncionario());
	}
	
	public Venda toEntity() {
		Venda venda = new Venda();
		venda.setIdVenda(this.idVenda);
		venda.setDtVenda(this.dtVenda);
		venda.setProduto(this.produto.toEntity());
		venda.setCliente(this.cliente.toEntity());
		venda.setFuncionario(this.funcionario.toEntity());
		return venda;
	}
}
