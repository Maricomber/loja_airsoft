package com.loja_airsoft.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "telefone")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tel_id_telefone")
	public Integer idTelefone;
	
	@Column(name = "tel_DDD", nullable = false)
	public Integer dddTelefone;
	
	@Column(name = "num_telefone", nullable = false)
	public Integer numTelefone;
	
	@ManyToOne(cascade = CascadeType.ALL)  
    @JoinColumn(name="usu_id_usuario", nullable = true)
	private Usuario usuario;
	
}
