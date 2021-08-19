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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ven_id_venda")
	private Integer idVenda;
	
	@Column(name = "ven_dt_venda", nullable = false)
	private Date dtVenda;
	
	@Column(name = "ven_vl_desconto", nullable = true)
	private Float vlDesconto;
	
	@Column(name = "ven_vl_total", nullable = false)
	private Float vlTotal;
	
	@ManyToOne(cascade = CascadeType.ALL)  
    @JoinColumn(name="usu_id_cliente")
	private Usuario cliente;

	@ManyToOne(cascade = CascadeType.ALL)  
    @JoinColumn(name="usu_id_vendedor")
	private Usuario vendedor;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "venda_produto",joinColumns = 
		{@JoinColumn(name = "ven_id_venda")}, inverseJoinColumns = 
		{@JoinColumn(name = "prd_id_produto")})
	private List<Produto> produto;
}
