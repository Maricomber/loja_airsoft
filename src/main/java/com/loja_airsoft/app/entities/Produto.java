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

import com.loja_airsoft.app.dtos.ProdutoDto;

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
	
	@ManyToOne(cascade = CascadeType.MERGE)  
    @JoinColumn(name="usu_id_usuario", nullable = true)
	private Usuario fabProduto;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Venda venda;

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="pdt_id_produto_tipo")
	private ProdutoTipo produtoTipo;
	
	public Produto() {
		
	}
	
	public Produto(ProdutoDto produtoDto) {
		this.idProduto = produtoDto.getIdProduto();
		this.dsProduto = produtoDto.getDsProduto();
		this.vlPreco = produtoDto.getVlPreco();
		this.fabProduto = new Usuario(produtoDto.getFabricante());
		this.produtoTipo = new ProdutoTipo(produtoDto.getProdutoTipoDto());
		
		if(!(produtoDto.getVendaDto() == null)) {
			this.venda = new Venda(produtoDto.getVendaDto());
		}
	}
	
}
