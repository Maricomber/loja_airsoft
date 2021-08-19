package com.loja_airsoft.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.loja_airsoft.app.dtos.PerfilDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "perfil")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pef_id_perfil", nullable = false)
	private int idPerfil;
	
	@Column(name = "pef_ds_perfil", nullable = false, length = 100)
	private String dsPerfil;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_perfil",joinColumns = 
		{@JoinColumn(name = "pef_id_perfil")}, inverseJoinColumns = 
		{@JoinColumn(name = "usu_id_usuario")})
	private List<Usuario> usuario;
	
	public Perfil() {
		
	}
	
	public Perfil(PerfilDto perfilDto) {
		this.idPerfil = perfilDto.getIdPerfil();
		this.dsPerfil = perfilDto.getDsPerfil();				
	}
}
