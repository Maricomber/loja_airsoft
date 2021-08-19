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
	public ClienteDto cliente;
	public FuncionarioDto funcionario;
	public List<ProdutoDto> produtoDto;
	
	public VendaDto() {
		
	}
	
	public VendaDto(Venda venda) {
		venda.getProduto().forEach(produto-> this.produtoDto.add(
				new ProdutoDto(produto)));
		this.idVenda = venda.getIdVenda();
		this.dtVenda = venda.getDtVenda();
		venda.getCliente().setVenda(null);
		this.cliente = new ClienteDto(venda.getCliente());
		this.funcionario = new FuncionarioDto(venda.getFuncionario());
	}
	
	public Venda toEntity() {
		
		Venda venda = new Venda();
		venda.setIdVenda(this.idVenda);
		venda.setDtVenda(this.dtVenda);
		venda.setCliente(this.cliente.toEntity());
		venda.setFuncionario(this.funcionario.toEntity());
		this.produtoDto.forEach(produto -> venda.getProduto().add(produto.toEntity()));
		return venda;
	}
}
