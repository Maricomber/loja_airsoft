package com.loja_airsoft.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.loja_airsoft.app.dtos.UsuarioDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id_usuario", nullable = true)
	private int idUsuario;
	
	@Column(name = "usu_dt_nascimento", nullable = false)
	private Date dtNascCliente;
	
	@Column(name = "usu_nm_usuario", nullable = false)
	private String nmUsuario;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_id_endereco", referencedColumnName = "end_id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Documento> documento;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Telefone> telefone;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Venda> venda;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Produto> produto;
	
	@ManyToMany
	@JoinTable(name = "usuario_perfil", joinColumns = 
	{@JoinColumn(name = "usu_id_usuario")}, inverseJoinColumns  =
	{@JoinColumn(name = "pef_id_perfil")})
	private List<Perfil> perfil;
	
	public Usuario() {
		
	}
	
	public Usuario(UsuarioDto usuarioDto) {
		this.idUsuario = usuarioDto.getIdUsuario();
		this.dtNascCliente = usuarioDto.getDtNascCliente();
		this.nmUsuario = usuarioDto.getNmUsuario();
		this.endereco = new Endereco(usuarioDto.getEndereco());
	}
}
