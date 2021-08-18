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
		this.idCliente = cliente.getIdCliente();
		this.cpfCliente = cliente.getCpfCliente();
		this.nmCliente = cliente.getNmCliente();
		this.dtNascCliente = cliente.getDtNascCliente();
		this.rgCliente = cliente.getRgCliente();
		this.enderecoDto = EnderecoDto.fromEntity(cliente.getEndereco(), false);
		this.telefoneDto = TelefoneDto.fromEntity(cliente.getTelefone(), false);
	}	
	
	public static Cliente toEntity(ClienteDto clienteDto) {
		
		return toEntity(clienteDto, true);
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
			
			if(isCliente){
				if(clienteDto.getTelefoneDto() != null) {
					for(TelefoneDto telefoneDto : clienteDto.getTelefoneDto()) {
						telefone.add(TelefoneDto.toEntity(telefoneDto, false));
					}
					cliente.setTelefone(telefone);
				}
				
				cliente.setEndereco(EnderecoDto.toEntity(clienteDto.getEnderecoDto(), false));
			}
			
		}
		return cliente;
	}
	
}
