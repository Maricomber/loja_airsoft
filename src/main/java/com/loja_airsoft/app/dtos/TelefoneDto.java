package com.loja_airsoft.app.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.Telefone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneDto {

	private Integer idTelefone;
	private Integer dddTelefone;
	private Integer numTelefone;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ClienteDto clienteDto;
	
	public static TelefoneDto fromEntity(Telefone telefone) {
		return fromEntity(telefone, true);
	}
	
	public static TelefoneDto fromEntity(Telefone telefone, Boolean isTelefone) {
		TelefoneDto telefoneDto = new TelefoneDto();
		telefoneDto.setIdTelefone(telefone.getIdTelefone());
		telefoneDto.setDddTelefone(telefone.getDddTelefone());
		telefoneDto.setNumTelefone(telefone.getNumTelefone());
		
		if(isTelefone) {
			telefoneDto.setClienteDto(ClienteDto.fromEntity(telefone.getCliente(), false));
		}
		return telefoneDto;
	}
	
	public static List<TelefoneDto> fromEntity(List<Telefone> telefone) {
		List<TelefoneDto>telefoneDto = new ArrayList<TelefoneDto>();
		
		for(Telefone telefoneUnid: telefone) {
			telefoneDto.add(fromEntity(telefoneUnid));
			
		}
		return telefoneDto;
	}
	
	public static Telefone toEntity(TelefoneDto telefoneDto) {
		return toEntity(telefoneDto, true);
	}
	
	public static Telefone toEntity(TelefoneDto telefoneDto, Boolean isTelefone) {
		Telefone telefone = new Telefone();
		telefone.setIdTelefone(telefoneDto.getIdTelefone());
		telefone.setDddTelefone(telefoneDto.getDddTelefone());
		telefone.setNumTelefone(telefoneDto.getNumTelefone());
		
		if(isTelefone) {
			telefone.setCliente(ClienteDto.toEntity(telefoneDto.getClienteDto(), false));
		}
		return telefone;
	}
	
	public static List<Telefone> toEntity(List<TelefoneDto> telefoneDto) {
		List<Telefone>telefone = new ArrayList<Telefone>();
		
		for(TelefoneDto telefoneUnid: telefoneDto) {
			telefone.add(toEntity(telefoneUnid));
			
		}
		return telefone;
	}
}
