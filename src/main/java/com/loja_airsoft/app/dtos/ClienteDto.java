package com.loja_airsoft.app.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.Cliente;
import com.loja_airsoft.app.entities.Telefone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
	private Integer idCliente;
	private Double cpfCliente;
	private String nmCliente;
	private Date dtNascCliente;
	private Integer rgCliente;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private EnderecoDto enderecoDto;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<TelefoneDto> telefoneDto;
	
	public ClienteDto(){
		
	}
	
	public ClienteDto(Cliente cliente) {			
		List<TelefoneDto>telefones = new ArrayList<TelefoneDto>();
		cliente.getTelefone().forEach(telefone -> telefones.add(new TelefoneDto(telefone)));
		
		this.idCliente = cliente.getIdCliente();
		this.cpfCliente = cliente.getCpfCliente();
		this.nmCliente = cliente.getNmCliente();
		this.dtNascCliente = cliente.getDtNascCliente();
		this.rgCliente = cliente.getRgCliente();
		this.enderecoDto = new EnderecoDto(cliente.getEndereco());
		this.telefoneDto = telefones;
	}	
	
	public Cliente toEntity() {
		Cliente cliente = new Cliente();
		List<Telefone>telefones = new ArrayList<Telefone>();
		this.telefoneDto.forEach(telefone -> telefones.add(telefone.toEntity()));
		
		cliente.setIdCliente(this.idCliente);
		cliente.setCpfCliente(this.cpfCliente);
		cliente.setNmCliente(this.nmCliente);
		cliente.setDtNascCliente(this.dtNascCliente);
		cliente.setRgCliente(this.rgCliente);
		cliente.setEndereco(this.enderecoDto.toEntity());
		cliente.setTelefone(telefones);
		
		return cliente;
	}
}
