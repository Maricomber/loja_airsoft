package com.loja_airsoft.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "produto_tipo")
public class ProdutoTipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pdt_id_produto_tipo")
	private int idProdutoTp;
	
	@Column(name = "pdt_ds_produto_tipo", nullable = false)
	private String dsProdutoTp;
	
	@OneToMany(mappedBy="produtoTipo")
	private List<Produto> produto;
	
}
