package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.UsuarioDto;
import com.loja_airsoft.app.entities.Usuario;
import com.loja_airsoft.app.repositories.UsuarioRepository;
import com.loja_airsoft.app.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Override
	public UsuarioDto save(UsuarioDto usuarioDto) throws Exception {
		
		if(usuarioDto.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		log.info("Salvando usuario");
		Usuario usuario = new Usuario(usuarioDto);
		
		try {
			usuario = this.usuarioRepository.save(usuario);
			return new UsuarioDto(usuario);
		}catch (Exception e) {
			msgErro = "Erro ao salvar usuario. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
	
	@Override
	public UsuarioDto findById(Integer id_usuario) throws Exception {
		log.info("Buscando usuario.");
		Usuario usuario = new Usuario();
		try {
			usuario = this.usuarioRepository.findByIdUsuario(id_usuario);
			if(usuario == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("Usuario encontrado.");
			return new UsuarioDto(usuario);
		}catch (Exception e) {
			msgErro = "Erro ao buscar usuario. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer id_usuario) throws Exception {
		
		Usuario usuario = new Usuario();
		log.info("Deletando usuario ");
		
		try{
			usuario = this.usuarioRepository.findByIdUsuario(id_usuario);
			this.usuarioRepository.delete(usuario);
		}catch (Exception e) {;
			msgErro = "Erro usuario não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<UsuarioDto> findUsuarios() throws Exception {
		log.info("Buscando todos os usuarios");
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<UsuarioDto> usuariosRetorno = new ArrayList<UsuarioDto>();
		
		try {
			usuarios = this.usuarioRepository.findAll();
			for(Usuario usuario: usuarios) {
				usuariosRetorno.add(new UsuarioDto(usuario));
			}
			log.info("Busca realizada com sucesso");
			return usuariosRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar usuarios. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
}
