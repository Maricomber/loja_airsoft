package com.loja_airsoft.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefone")
public class Telefone {

	public Integer idTelefone;
	public Integer dddTelefone;
	public Integer numTelefone;
	public Cliente cliente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tel_id_telefone")
	public Integer getIdTelefone() {
		return idTelefone;
	}
	
	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}

	@Column(name = "tel_DDD", nullable = false)
	public Integer getDDDTelefone() {
		return dddTelefone;
	}

	public void setDDDTelefone(Integer dddTelefone) {
		this.dddTelefone = dddTelefone;
	}
	
	@Column(name = "num_telefone", nullable = false)
	public Integer getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(Integer numTelefone) {
		this.numTelefone = numTelefone;
	}
	
}
