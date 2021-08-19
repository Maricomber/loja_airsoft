package com.loja_airsoft.app.dtos;

import java.math.BigInteger;
import java.util.Date;
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
	
	public FuncionarioDto(Funcionario funcionario) {
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
		return funcionario;
	}
}
