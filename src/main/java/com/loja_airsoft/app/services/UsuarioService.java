package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.PerfilDto;
import com.loja_airsoft.app.dtos.UsuarioDto;

@Service
public interface UsuarioService {

	UsuarioDto save(UsuarioDto usuarioDto) throws Exception;
	
	UsuarioDto findById(Integer id_usuario) throws Exception;
	
	Boolean delete(Integer id_usuario) throws Exception;
	
	List<UsuarioDto>findUsuarios() throws Exception;
	
	List<UsuarioDto>findUsuarios(PerfilDto perfilDto) throws Exception;
	
}
