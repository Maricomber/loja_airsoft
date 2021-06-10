package com.loja_airsoft.app.dtos;

import java.util.Date;

import com.loja_airsoft.app.entities.Cliente;
import com.loja_airsoft.app.entities.Endereco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
	private Integer cpfCliente;
	private String nmCliente;
	private Date dtNasCliente;
	private Integer rgCliente;
	private Endereco endereço;
	
	public static ClienteDto fromEntity(Cliente cliente) {
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setCpfCliente(cliente.getCpfCliente());
		clienteDto.setNmCliente(cliente.getNmCliente());
		clienteDto.setDtNasCliente(cliente.getDtNascCliente());
		clienteDto.setRgCliente(cliente.getRgCliente());
		clienteDto.setEndereço(cliente.getEndereco());
		return clienteDto;
	}
	
	public static Cliente toEntity(ClienteDto clienteDto) {
		Cliente cliente = new Cliente();
		cliente.setCpfCliente(clienteDto.getCpfCliente());
		cliente.setNmCliente(clienteDto.getNmCliente());
		cliente.setDtNascCliente(clienteDto.getDtNasCliente());
		cliente.setRgCliente(clienteDto.getRgCliente());
		cliente.SetEndereco(clienteDto.getEndereço());
		return cliente;
	}
}
