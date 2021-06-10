package com.loja_airsoft.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	private Integer cpfCliente;
	private String nmCliente;
	private Date dtNasCliente;
	private Integer rgCliente;
	private Endereco endereco;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_cpf", nullable = false)
	public Integer getCpfCliente() {
		return cpfCliente;
	}
	
	public void setCpfCliente(Integer cpfCliente) {
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
	@Column(name = "end_id_endereco", nullable = false)
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void SetEndereco(Endereco idEndereço) {
		this.endereco = idEndereço;
	}
	
}
