package com.loja_airsoft.app.dtos;


import com.loja_airsoft.app.entities.Telefone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneDto {

	private Integer idTelefone;
	private Integer dddTelefone;
	private Integer numTelefone;
	
	public TelefoneDto() {
		
	}
	
	public TelefoneDto(Telefone telefone) {
		this.idTelefone = telefone.getIdTelefone();
		this.dddTelefone = telefone.getDddTelefone();
		this.numTelefone = telefone.getNumTelefone();
	}

}
