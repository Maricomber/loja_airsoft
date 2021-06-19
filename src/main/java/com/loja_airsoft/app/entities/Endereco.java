package com.loja_airsoft.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "end_id_endereco", nullable = false)
	private Integer idEndereco;
	
	@Column(name = "end_rua", nullable = false)
	private String dsRua;
	
	@Column(name = "end_numero", nullable = false)
	private Integer endNumero;
	
	@Column(name = "end_bairro", nullable = false)
	private String endBairro;
	
	@Column(name = "end_cidade", nullable = false)
	private String endCidade;
	
	@Column(name = "end_complemento", nullable = true)
	private String endComplemento;
		
	@OneToOne(mappedBy = "endereco")
	private Cliente cliente;

}
