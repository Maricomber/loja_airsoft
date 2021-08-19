package com.loja_airsoft.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany
	@Column(name = "prd_id_fabricante", nullable = false)
	private Usuario fabProduto;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ven_id_venda")
	private Venda venda;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "venda_produto",joinColumns = 
		{@JoinColumn(name = "prd_id_produto")}, inverseJoinColumns = 
		{@JoinColumn(name = "ven_id_venda")})
	private ProdutoTipo produtoTipo;
}
