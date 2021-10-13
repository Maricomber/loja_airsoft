package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.PerfilDto;
import com.loja_airsoft.app.entities.Perfil;
import com.loja_airsoft.app.repositories.PerfilRepository;
import com.loja_airsoft.app.services.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService {
	
	@Autowired
	PerfilRepository perfilRepository;
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(PerfilServiceImpl.class);
	
	@Override
	public PerfilDto save(PerfilDto perfilDto) throws Exception {
		
		if(perfilDto.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		log.info("Salvando perfil");
		
		try {
			Perfil perfil = new Perfil(perfilDto);
			perfil = this.perfilRepository.save(perfil);
			return new PerfilDto(perfil);
		}catch (Exception e) {
			msgErro = "Erro ao salvar perfil. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
	

	@Override
	public PerfilDto findById(Integer id_perfil) throws Exception {
		log.info("Buscando perfil.");
		Perfil perfil = new Perfil();
		try {
			perfil = this.perfilRepository.findByIdPerfil(id_perfil);
			if(perfil == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("Perfil encontrado.");
			return new PerfilDto(perfil);
		}catch (Exception e) {
			msgErro = "Erro ao buscar perfil. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer id_perfil) throws Exception {
		
		Perfil perfil = new Perfil();
		log.info("Deletando perfil ");
		
		try{
			perfil = this.perfilRepository.findByIdPerfil(id_perfil);
			this.perfilRepository.delete(perfil);
		}catch (Exception e) {;
			msgErro = "Erro perfil não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<PerfilDto> findPerfils() throws Exception {
		log.info("Buscando todos os perfils");
		List<Perfil> perfils = new ArrayList<Perfil>();
		List<PerfilDto> perfilsRetorno = new ArrayList<PerfilDto>();
		
		try {
			perfils = this.perfilRepository.findAllByOrderByIdPerfil();
			for(Perfil perfil: perfils) {
				perfilsRetorno.add(new PerfilDto(perfil));
			}
			log.info("Busca realizada com sucesso");
			return perfilsRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar perfils. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}


	@Override
	public List<PerfilDto> findByPerfil(PerfilDto perfilDto) throws Exception {
		log.info("Buscando perfil.");
		List<Perfil>perfis = new ArrayList<Perfil>();
		List<PerfilDto> retorno = new ArrayList<PerfilDto>();
		
		try {
			
			if(!perfilDto.getDsPerfil().equals("")) {
				perfis = this.perfilRepository.findByDsPerfilIgnoreCaseContaining(perfilDto.getDsPerfil());
			}
			if(!(perfilDto.getIdPerfil() == null)) {
				Perfil perfil = this.perfilRepository.findByIdPerfil(perfilDto.getIdPerfil());
				if(!(perfis.contains(perfil))) {
					perfis.add(perfil);
				}
			}
			
			if(perfis.size() == 0) {
				throw new Exception("Sem resultados.");
			}
			log.info("Perfil encontrado.");
			
			for(Perfil p: perfis) {
				retorno.add(new PerfilDto(p));
			}
			return retorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar perfil. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
}