package com.loja_airsoft.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "fabricante")
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fab_id_fabricante", nullable = true)
	private Integer idFabricante;
	
	@Column(name = "fab_nm_fantasia", nullable = false, length = 255)
	private String nmFantasiaFab;
	
	@Column(name = "fab_cnpj", nullable = false, length = 20)
	private String cnpjFabricante;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy="fabricante", cascade = CascadeType.ALL)
	private List<Produto> produto;
}
