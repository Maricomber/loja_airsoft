package com.loja_airsoft.app.dtos;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDto {
	
	private Double cpfFunc;
	private Date dtNascFun;
	private String nmFunc;
	private Date dtContFunc;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private CargoDto cargo;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private EnderecoDto enderecoDto;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<TelefoneDto> telefoneDto;
	
	
}
