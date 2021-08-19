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
	
	public FabricanteDto() {
		
	}
	public FabricanteDto(Fabricante fabricante) {
		this.idFabricante = fabricante.getIdFabricante();
		this.nmFantasiaFab = fabricante.getNmFantasiaFab();
		this.cnpjFabricante = fabricante.getCnpjFabricante();
		this.enderecoDto = new EnderecoDto(fabricante.getEndereco());
	}
		
	public Fabricante toEntity() {
		Fabricante fabricante = new Fabricante();
		fabricante.setIdFabricante(this.idFabricante);
		fabricante.setNmFantasiaFab(this.nmFantasiaFab);
		fabricante.setCnpjFabricante(this.cnpjFabricante);
		fabricante.setEndereco(this.enderecoDto.toEntity());
		
		return fabricante;
	}
	
}
