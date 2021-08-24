package com.loja_airsoft.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.loja_airsoft.app.dtos.ProdutoTipoDto;

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
	
	@OneToMany(mappedBy="produtoTipo", cascade = CascadeType.ALL)
	private List<Produto> produto;
	
	public ProdutoTipo() {
		
	}
	
	public ProdutoTipo(ProdutoTipoDto produtoTipoDto) {
		this.idProdutoTp = produtoTipoDto.getIdProdutoTp();
		this.dsProdutoTp = produtoTipoDto.getDsProdutoTp();
	}
	
}
