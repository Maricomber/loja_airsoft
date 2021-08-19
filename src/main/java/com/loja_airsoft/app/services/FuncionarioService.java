package com.loja_airsoft.app.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.FuncionarioDto;

@Service
public interface FuncionarioService {

	FuncionarioDto save(FuncionarioDto funcionarioDto) throws Exception;
	
	FuncionarioDto findById(BigInteger id_funcionario) throws Exception;
	
	Boolean delete(BigInteger id_funcionario) throws Exception;
	
	List<FuncionarioDto>findFuncionarios() throws Exception;
	
}
