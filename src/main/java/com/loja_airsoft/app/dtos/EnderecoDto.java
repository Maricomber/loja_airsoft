package com.loja_airsoft.app.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.Endereco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {

	private Integer idEndereco;
	private String dsRua;
	private Integer endNumero;
	private String endBairro;
	private String endCidade;
	private String endComplemento;
	private String endCep;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ClienteDto clienteDto;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private FabricanteDto fabricanteDto;
	
	public static EnderecoDto fromEntity(Endereco endereco) {
		return fromEntity(endereco, false);
	}
	public static EnderecoDto fromEntity(Endereco endereco, Boolean verCliente) {
		EnderecoDto enderecoDto = new EnderecoDto();
		if(!(endereco == null)) {
			enderecoDto.setIdEndereco(endereco.getIdEndereco());
			enderecoDto.setDsRua(endereco.getDsRua());
			enderecoDto.setEndNumero(endereco.getEndNumero());
			enderecoDto.setEndBairro(endereco.getEndBairro());
			enderecoDto.setEndCidade(endereco.getEndCidade());
			enderecoDto.setEndComplemento(endereco.getEndComplemento());
			enderecoDto.setEndCep(endereco.getEndCep());
			
			if(verCliente.equals(false)) {
				enderecoDto.setClienteDto(ClienteDto.fromEntity(endereco.getCliente(), true));
				enderecoDto.setFabricanteDto(FabricanteDto.fromEntity(endereco.getFabricante(), true));
			}
		}
		return enderecoDto;
	}
	
	public static Endereco toEntity(EnderecoDto enderecoDto) {
		return toEntity(enderecoDto, false);
	}
	
	public static Endereco toEntity(EnderecoDto enderecoDto, Boolean verEndereco) {
		Endereco endereco = new Endereco();
		if(!(endereco == null)) {
			endereco.setIdEndereco(enderecoDto.getIdEndereco());
			endereco.setDsRua(enderecoDto.getDsRua());
			endereco.setEndNumero(enderecoDto.getEndNumero());
			endereco.setEndBairro(enderecoDto.getEndBairro());
			endereco.setEndCidade(enderecoDto.getEndCidade());
			endereco.setEndComplemento(enderecoDto.getEndComplemento());
			endereco.setEndCep(enderecoDto.getEndCep());
			
			if(verEndereco.equals(false)) {
				endereco.setFabricante(FabricanteDto.toEntity(enderecoDto.getFabricanteDto(), true));
				endereco.setCliente(ClienteDto.toEntity(enderecoDto.getClienteDto(), true));
			}
		}
		
		return endereco;
	}
}
