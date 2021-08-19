package com.loja_airsoft.app.dtos;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.loja_airsoft.app.entities.Funcionario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDto {
	
	private BigInteger cpfFunc;
	private Date dtNascFun;
	private String nmFunc;
	private Date dtContFunc;
	private CargoDto cargoDto;
	private EnderecoDto enderecoDto;
	private List<TelefoneDto> telefoneDto;
	
	public FuncionarioDto() {
		
	}
	
	public FuncionarioDto(Funcionario funcionario) {
		
		if(!(funcionario.getTelefone() == null)) {
			funcionario.getTelefone().forEach(telefone -> this.telefoneDto.add(new TelefoneDto(telefone)));
		}
		if(!(funcionario.getEndereco()== null)) {
			this.enderecoDto = new EnderecoDto(funcionario.getEndereco());
		}
		if(!(funcionario.getCargo() == null)) {
			this.cargoDto = new CargoDto(funcionario.getCargo());
		}
		this.cpfFunc = funcionario.getCpfFunc();
		this.dtNascFun = funcionario.getDtNascFun();
		this.nmFunc = funcionario.getNmFunc();
		this.dtContFunc = funcionario.getDtContFunc();
	
	}
	
	public Funcionario toEntity() {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCpfFunc(this.cpfFunc);
		funcionario.setDtNascFun(this.dtNascFun);
		funcionario.setNmFunc(this.nmFunc);
		funcionario.setDtContFunc(this.dtContFunc);

		if(!(this.cargoDto == null)) {
			funcionario.setCargo(this.cargoDto.toEntity());
		}
		if(!(this.enderecoDto == null)) {
			funcionario.setEndereco(this.enderecoDto.toEntity());
		}
		if(!(this.telefoneDto == null)) {
			this.telefoneDto.forEach(telefone -> funcionario.getTelefone().add(telefone.toEntity()));
		}
		 
		return funcionario;
	}
}
