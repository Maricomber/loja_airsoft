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

	public static CargoDto fromEntity(Cargo cargo) {
		CargoDto cargoDto = new CargoDto();
		cargoDto.setIdCargo(cargo.getIdCargo());
		cargoDto.setDsCargo(cargo.getDsCargo());
		return cargoDto;
	}
	
	public static Cargo toEntity(CargoDto cargoDto) {
		Cargo cargo = new Cargo();
		cargo.setIdCargo(cargoDto.getIdCargo());
		cargo.setDsCargo(cargoDto.getDsCargo());
		return cargo;
	}
	
}
