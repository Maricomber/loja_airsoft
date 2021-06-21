package com.loja_airsoft.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_id_cliente", nullable = true)
	private Integer idCliente;
	
	@Column(name = "cli_cpf", nullable = false)
	private Double cpfCliente;
	
	@Column(name = "cli_nome", nullable = false, length = 200)
	private String nmCliente;
	
	@Column(name = "cli_dt_nascimento", nullable = false)
	private Date dtNascCliente;
	
	@Column(name = "cli_rg", nullable = false)
	private Integer rgCliente;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "cliente")
	private List<Telefone> telefone;
	
}
