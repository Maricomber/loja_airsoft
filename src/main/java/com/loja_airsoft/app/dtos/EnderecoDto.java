package com.loja_airsoft.app.dtos;

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
	
	public static EnderecoDto fromEntity(Endereco endereco) {
		EnderecoDto enderecoDto = new EnderecoDto();
		if(!(endereco == null)) {
			enderecoDto.setIdEndereco(endereco.getIdEndereco());
			enderecoDto.setDsRua(endereco.getDsRua());
			enderecoDto.setEndNumero(endereco.getEndNumero());
			enderecoDto.setEndBairro(endereco.getEndBairro());
			enderecoDto.setEndCidade(endereco.getEndCidade());
			enderecoDto.setEndComplemento(endereco.getEndComplemento());
		}
		return enderecoDto;
	}
	
	public static Endereco toEntity(EnderecoDto enderecoDto) {
		Endereco endereco = new Endereco();
		if(!(endereco == null)) {
			endereco.setIdEndereco(enderecoDto.getIdEndereco());
			endereco.setDsRua(enderecoDto.getDsRua());
			endereco.setEndNumero(enderecoDto.getEndNumero());
			endereco.setEndBairro(enderecoDto.getEndBairro());
			endereco.setEndCidade(enderecoDto.getEndCidade());
			endereco.setEndComplemento(enderecoDto.getEndComplemento());
		}
		
		return endereco;
	}
}
