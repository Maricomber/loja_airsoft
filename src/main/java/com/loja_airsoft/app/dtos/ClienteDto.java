package com.loja_airsoft.app.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private EnderecoDto enderecoDto;
	private List<TelefoneDto> telefoneDto;
	
	public static ClienteDto fromEntity(Cliente cliente) {
		List<TelefoneDto> telefoneD = new ArrayList<TelefoneDto>();
		ClienteDto clienteDto = new ClienteDto();
		
		if(!(cliente == null)) {
			clienteDto.setIdCliente(cliente.getIdCliente());
			clienteDto.setCpfCliente(cliente.getCpfCliente());
			clienteDto.setNmCliente(cliente.getNmCliente());
			clienteDto.setDtNascCliente(cliente.getDtNascCliente());
			clienteDto.setRgCliente(cliente.getRgCliente());
			if(cliente.getTelefone() != null) {
				for(Telefone telefone : cliente.getTelefone()) {
					telefoneD.add(TelefoneDto.fromEntity(telefone));
				}
			}
			clienteDto.setTelefoneDto(telefoneD);
			clienteDto.setEnderecoDto(EnderecoDto.fromEntity(cliente.getEndereco()));
		}
		return clienteDto;
	}
	
	public static Cliente toEntity(ClienteDto clienteDto) {
		List<Telefone>telefone = new ArrayList<Telefone>();
		Cliente cliente = new Cliente();
		
		if(!(cliente == null))  {
			cliente.setIdCliente(clienteDto.getIdCliente());
			cliente.setCpfCliente(clienteDto.getCpfCliente());
			cliente.setNmCliente(clienteDto.getNmCliente());
			cliente.setDtNascCliente(clienteDto.getDtNascCliente());
			cliente.setRgCliente(clienteDto.getRgCliente());
			
			if(clienteDto.getTelefoneDto() != null) {
				for(TelefoneDto telefoneDto : clienteDto.getTelefoneDto()) {
					telefone.add(TelefoneDto.toEntity(telefoneDto));
				}
				cliente.setTelefone(telefone);
			}
			cliente.setEndereco(EnderecoDto.toEntity(clienteDto.getEnderecoDto()));
			
		}
		return cliente;
	}
}
