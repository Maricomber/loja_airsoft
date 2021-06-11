package com.loja_airsoft.app.dtos;

import java.util.ArrayList;
import java.util.List;

import com.loja_airsoft.app.entities.Telefone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneDto {

	public Integer idTelefone;
	public Integer dddTelefone;
	public Integer numTelefone;
	public Integer idCliente;
	
	public static TelefoneDto fromEntity(Telefone telefone) {
		TelefoneDto telefoneDto = new TelefoneDto();
		telefoneDto.setIdTelefone(telefone.getIdTelefone());
		telefoneDto.setDddTelefone(telefone.getDDDTelefone());
		telefoneDto.setNumTelefone(telefone.getNumTelefone());
		telefoneDto.setIdCliente(telefone.getIdCliente());
		//telefoneDto.setClienteDto(ClienteDto.fromEntity(telefone.getCliente()));
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
		Telefone telefone = new Telefone();
		telefone.setIdTelefone(telefoneDto.getIdTelefone());
		telefone.setDDDTelefone(telefoneDto.getDddTelefone());
		telefone.setNumTelefone(telefoneDto.getNumTelefone());
		telefone.setIdCliente(telefoneDto.getIdCliente());
		//telefone.setCliente(ClienteDto.toEntity(telefoneDto.getClienteDto()));
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
