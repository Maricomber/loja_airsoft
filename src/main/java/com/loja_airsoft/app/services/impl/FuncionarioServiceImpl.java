package com.loja_airsoft.app.services.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.FuncionarioDto;
import com.loja_airsoft.app.entities.Funcionario;
import com.loja_airsoft.app.repositories.FuncionarioRepository;
import com.loja_airsoft.app.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {


	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);
	
	
	@Override
	public FuncionarioDto save(FuncionarioDto funcionarioDto) throws Exception {
		
		if(funcionarioDto.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		log.info("Salvando funcionario");
		Funcionario funcionario = new Funcionario();
		try {
			funcionario = this.funcionarioRepository.save(funcionarioDto.toEntity());
			return new FuncionarioDto(funcionario);
		}catch (Exception e) {
			msgErro = "Erro ao salvar funcionario. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
	

	@Override
	public FuncionarioDto findById(BigInteger id_funcionario) throws Exception {
		log.info("Buscando funcionario.");
		Funcionario funcionario = new Funcionario();
		try {
			funcionario = this.funcionarioRepository.findByCpfFunc(id_funcionario);
			if(funcionario == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("Funcionario encontrado.");
			return new FuncionarioDto(funcionario);
		}catch (Exception e) {
			msgErro = "Erro ao buscar funcionario. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(BigInteger id_funcionario) throws Exception {
		
		Funcionario funcionario = new Funcionario();
		log.info("Deletando funcionario ");
		
		try{
			funcionario = this.funcionarioRepository.findByCpfFunc(id_funcionario);
			this.funcionarioRepository.delete(funcionario);
		}catch (Exception e) {;
			msgErro = "Erro funcionario não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<FuncionarioDto> findFuncionarios() throws Exception {
		log.info("Buscando todos os funcionarios");
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		List<FuncionarioDto> funcionariosRetorno = new ArrayList<FuncionarioDto>();
		
		try {
			funcionarios = this.funcionarioRepository.findAll();
			for(Funcionario funcionario: funcionarios) {
				funcionariosRetorno.add(new FuncionarioDto(funcionario));
			}
			log.info("Busca realizada com sucesso");
			return funcionariosRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar funcionarios. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
}
