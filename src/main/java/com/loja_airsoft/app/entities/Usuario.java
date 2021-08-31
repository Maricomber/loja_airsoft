package com.loja_airsoft.app.entities;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Cargo cargo;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Documento> documento = new ArrayList<Documento>();
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Telefone> telefone = new ArrayList<Telefone>();
	
	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
	private List<Venda> venda = new ArrayList<Venda>();
	
	@OneToMany(mappedBy = "fabProduto", cascade = CascadeType.ALL)
	private List<Produto> produto = new ArrayList<Produto>();
	
	
	@ManyToMany
	@JoinTable(name = "usuario_perfil", joinColumns = 
	{@JoinColumn(name = "usu_id_usuario")}, inverseJoinColumns  =
	{@JoinColumn(name = "pef_id_perfil")})
	private List<Perfil> perfil = new ArrayList<Perfil>();
	
	public Usuario() {
		
	}
	
	public Usuario(UsuarioDto usuarioDto) {
		this.idUsuario = usuarioDto.getIdUsuario();
		this.dtNascCliente = usuarioDto.getDtNascCliente();
		this.nmUsuario = usuarioDto.getNmUsuario();
		this.endereco = new Endereco(usuarioDto.getEndereco());
		if(!(usuarioDto.getCargo() == null)) {
			this.cargo = new Cargo(usuarioDto.getCargo());
		}
		
		if(!(usuarioDto.getDocumento()== null)) {
			usuarioDto.getDocumento().forEach(documento -> this.documento.add(new Documento(documento)));
		}
		if(!(usuarioDto.getTelefone()== null)) {
			usuarioDto.getTelefone().forEach(telefone -> this.telefone.add(new Telefone(telefone)));
		}
		if(!(usuarioDto.getVenda()== null)) {
			usuarioDto.getVenda().forEach(venda -> this.venda.add(new Venda(venda)));
			
		}
		if(!(usuarioDto.getPerfil()== null)) {
			usuarioDto.getPerfil().forEach(perfil -> this.perfil.add(new Perfil(perfil)));
		}
	}
}
