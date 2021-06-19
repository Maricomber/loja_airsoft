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
	
	public static TelefoneDto fromEntity(Telefone telefone) {
		TelefoneDto telefoneDto = new TelefoneDto();
		telefoneDto.setIdTelefone(telefone.getIdTelefone());
		telefoneDto.setDddTelefone(telefone.getDddTelefone());
		telefoneDto.setNumTelefone(telefone.getNumTelefone());
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
		telefone.setDddTelefone(telefoneDto.getDddTelefone());
		telefone.setNumTelefone(telefoneDto.getNumTelefone());
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
