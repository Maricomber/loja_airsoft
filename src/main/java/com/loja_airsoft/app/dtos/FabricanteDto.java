package com.loja_airsoft.app.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.Fabricante;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FabricanteDto {
	
	private Integer idFabricante;
	private String nmFantasiaFab;
	private String cnpjFabricante;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private EnderecoDto enderecoDto;
	
	public static FabricanteDto fromEntity(Fabricante fabricante) {
		return fromEntity(fabricante, false);
	}
	
	public static FabricanteDto fromEntity(Fabricante fabricante, Boolean isFabricante) {
		FabricanteDto fabricanteDto = new FabricanteDto();
		fabricanteDto.setIdFabricante(fabricante.getIdFabricante());
		fabricanteDto.setNmFantasiaFab(fabricante.getNmFantasiaFab());
		fabricanteDto.setCnpjFabricante(fabricante.getCnpjFabricante());
		
		if(isFabricante.equals(false)) {
			fabricanteDto.setEnderecoDto(EnderecoDto.fromEntity(fabricante.getEndereco(), true));
		}
		return fabricanteDto;
	}
	
	public static Fabricante toEntity(FabricanteDto fabricanteDto) {
		return toEntity(fabricanteDto, false);
	}
	public static Fabricante toEntity(FabricanteDto fabricanteDto, Boolean isFabricante) {
		Fabricante fabricante = new Fabricante();
		fabricante.setIdFabricante(fabricanteDto.getIdFabricante());
		fabricante.setNmFantasiaFab(fabricanteDto.getNmFantasiaFab());
		fabricante.setCnpjFabricante(fabricanteDto.getCnpjFabricante());
		if(isFabricante.equals(false)) {
			fabricante.setEndereco(EnderecoDto.toEntity(fabricanteDto.getEnderecoDto(), true));
		}
		return fabricante;
	}
	
}
