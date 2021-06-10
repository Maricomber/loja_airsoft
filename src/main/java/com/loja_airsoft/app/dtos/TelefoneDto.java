package com.loja_airsoft.app.dtos;

import com.loja_airsoft.app.entities.Cliente;
import com.loja_airsoft.app.entities.Telefone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneDto {

	public Integer idTelefone;
	public Integer dddTelefone;
	public Integer numTelefone;
	public Cliente cliente;
	
	public static TelefoneDto fromEntity(Telefone telefone) {
		TelefoneDto telefoneDto = new TelefoneDto();
		telefoneDto.setIdTelefone(telefone.getIdTelefone());
		telefoneDto.setDddTelefone(telefone.getDDDTelefone());
		telefoneDto.setNumTelefone(telefone.getNumTelefone());
		telefoneDto.setCliente(telefone.getCliente());
		return telefoneDto;
	}
	
	public static Telefone toEntity(TelefoneDto telefoneDto) {
		Telefone telefone = new Telefone();
		telefone.setIdTelefone(telefoneDto.getIdTelefone());
		telefone.setDDDTelefone(telefoneDto.getDddTelefone());
		telefone.setNumTelefone(telefoneDto.getDddTelefone());
		telefone.setCliente(telefoneDto.getCliente());
		return telefone;
	}
}
