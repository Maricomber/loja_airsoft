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
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prd_id_produto")
	private int idProduto;
	
	@Column(name = "prd_ds_produto", nullable = false)
	private String dsProduto;
	
	@Column(name = "prd_preco", nullable = false)
	private float vlPreco;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fab_id_fabricante")
	private Fabricante fabricante;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pdt_id_produto_tipo")
	private ProdutoTipo produtoTipo;
	
	
}
