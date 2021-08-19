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
	private UsuarioDto usuarioDto;

	public EnderecoDto() {
		
	}
	
	public EnderecoDto (Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.dsRua = endereco.getDsRua();
		this.endNumero = endereco.getEndNumero();
		this.endBairro = endereco.getEndBairro();
		this.endCidade = endereco.getEndCidade();
		this.endComplemento = endereco.getEndComplemento();
		this.endCep = endereco.getEndCep();

	}
	
	public Endereco toEntity() {
		Endereco endereco = new Endereco();
		
		endereco.setIdEndereco(this.idEndereco);
		endereco.setDsRua(this.dsRua);
		endereco.setEndNumero(this.endNumero);
		endereco.setEndBairro(this.endBairro);
		endereco.setEndCidade(this.endCidade);
		endereco.setEndComplemento(this.endComplemento);
		endereco.setEndCep(this.endCep);
		
		if(!(this.usuarioDto == null)) {
			//endereco.setCliente(this.usuarioDto.toEntity());
		}
		
		return endereco;
	}

}
