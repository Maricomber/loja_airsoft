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
	
	public static ClienteDto fromEntity(Cliente cliente) {
			
			return fromEntity(cliente, false);
	}
	
	public static ClienteDto fromEntity(Cliente cliente, Boolean isCliente) {
		List<TelefoneDto> telefoneD = new ArrayList<TelefoneDto>();
		ClienteDto clienteDto = new ClienteDto();
		
		if(!(cliente == null)) {
			clienteDto.setIdCliente(cliente.getIdCliente());
			clienteDto.setCpfCliente(cliente.getCpfCliente());
			clienteDto.setNmCliente(cliente.getNmCliente());
			clienteDto.setDtNascCliente(cliente.getDtNascCliente());
			clienteDto.setRgCliente(cliente.getRgCliente());
			
			if (isCliente.equals(false)) {
				if(cliente.getTelefone() != null) {
					for(Telefone telefone : cliente.getTelefone()) {
						telefoneD.add(TelefoneDto.fromEntity(telefone, true));
					}
				}
				clienteDto.setTelefoneDto(telefoneD);
				clienteDto.setEnderecoDto(EnderecoDto.fromEntity(cliente.getEndereco(), true));
			}
		}
		return clienteDto;
	}
	
	public static Cliente toEntity(ClienteDto clienteDto) {
		
		return toEntity(clienteDto, false);
	}

	public static Cliente toEntity(ClienteDto clienteDto, Boolean isCliente) {
		List<Telefone>telefone = new ArrayList<Telefone>();
		Cliente cliente = new Cliente();
		
		if(!(cliente == null))  {
			cliente.setIdCliente(clienteDto.getIdCliente());
			cliente.setCpfCliente(clienteDto.getCpfCliente());
			cliente.setNmCliente(clienteDto.getNmCliente());
			cliente.setDtNascCliente(clienteDto.getDtNascCliente());
			cliente.setRgCliente(clienteDto.getRgCliente());
			
			if(isCliente.equals(true)){
				if(clienteDto.getTelefoneDto() != null) {
					for(TelefoneDto telefoneDto : clienteDto.getTelefoneDto()) {
						telefone.add(TelefoneDto.toEntity(telefoneDto));
					}
					cliente.setTelefone(telefone);
				}
				
				cliente.setEndereco(EnderecoDto.toEntity(clienteDto.getEnderecoDto()));
			}
			
		}
		return cliente;
	}
}
