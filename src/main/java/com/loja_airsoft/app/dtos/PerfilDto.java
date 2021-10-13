package com.loja_airsoft.app.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.Perfil;
import com.loja_airsoft.app.entities.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilDto {

	private Integer idPerfil;
	private String dsPerfil;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Usuario> usuario = new ArrayList<Usuario>();
	
	public PerfilDto() {
		
	}
	
	public PerfilDto(Perfil perfil) {
		this.idPerfil = perfil.getIdPerfil();
		this.dsPerfil = perfil.getDsPerfil();
	}
}
