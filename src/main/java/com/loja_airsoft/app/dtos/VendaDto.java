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
		this.produto = ProdutoDto.fromEntity(venda.getProduto(), false);
				//venda.getProduto();
		this.cliente = ClienteDto.fromEntity(venda.getCliente(), false);
		this.funcionario = new FuncionarioDto(venda.getFuncionario());
	}
	
	public static Venda toEntity(VendaDto vendaDto) {
		Venda venda = new Venda();
		venda.setIdVenda(vendaDto.getIdVenda());
		venda.setDtVenda(vendaDto.getDtVenda());
		venda.setProduto(ProdutoDto.toEntity(vendaDto.getProduto()));
		venda.setCliente(ClienteDto.toEntity(vendaDto.getCliente()));
		venda.setFuncionario(vendaDto.funcionario.toEntity());
		return venda;
	}
}
