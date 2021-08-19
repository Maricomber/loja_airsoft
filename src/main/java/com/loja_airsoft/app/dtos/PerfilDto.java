package com.loja_airsoft.app.dtos;

import java.util.List;

import com.loja_airsoft.app.entities.Perfil;
import com.loja_airsoft.app.entities.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilDto {

	private int idPerfil;
	private String dsPerfil;
	private List<Usuario> usuario;
	
	public PerfilDto() {
		
	}
	
	public PerfilDto(Perfil perfil) {
		this.idPerfil = perfil.getIdPerfil();
		this.dsPerfil = perfil.getDsPerfil();
		perfil.getUsuario().forEach(usuario -> this.usuario.add(usuario));
	}
}
