package com.loja_airsoft.app.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente")
public class Cliente {
	private Integer idCliente;
	private Double cpfCliente;
	private String nmCliente;
	private Date dtNasCliente;
	private Integer rgCliente;
	private Endereco endereco;
	private List<Telefone> telefone;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_id_cliente", nullable = false)
	public Integer getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	
	@Column(name = "cli_cpf", nullable = false)
	public Double getCpfCliente() {
		return cpfCliente;
	}
	
	public void setCpfCliente(Double cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	@Column(name = "cli_nome", nullable = false)
	public String getNmCliente() {
		return nmCliente;
	}
	
	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}
	
	@Column(name = "cli_dt_nascimento", nullable = false)
	public Date getDtNascCliente() {
		return dtNasCliente;
	}
	
	public void setDtNascCliente(Date dtNasCliente) {
		this.dtNasCliente = dtNasCliente;
	}
	
	@Column(name = "cli_rg", nullable = false)
	public Integer getRgCliente() {
		return rgCliente;
	}
	
	public void setRgCliente(Integer rgCliente) {
		this.rgCliente = rgCliente;
	}
	
	@OneToOne
	@JoinColumn(name = "end_id_endereco", nullable = true)
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco idEndereço) {
		this.endereco = idEndereço;
	}
	
	
	@ManyToMany
	@JoinColumn(name = "cli_id_cliente", nullable = true)
	public List<Telefone> getTelefone() {
		return telefone;
	}
	
	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}
}
