package com.loja_airsoft.app.dtos;

import com.loja_airsoft.app.dtos.CargoDto;
import com.loja_airsoft.app.entities.Cargo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoDto {

	private Integer idCargo;
	private String dsCargo;

	public CargoDto(){
		
	}
	
	public CargoDto(Cargo cargo) {
		this.idCargo = cargo.getIdCargo();
		this.dsCargo = cargo.getDsCargo();
	}
	
}
