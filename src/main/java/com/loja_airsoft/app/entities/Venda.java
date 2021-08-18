package com.loja_airsoft.app.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prd_id_produto", nullable = false)
	private Produto produto;
	
	@ManyToOne(cascade = CascadeType.ALL)  
    @JoinColumn(name="cli_id_cliente")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)  
    @JoinColumn(name="fun_cpf_vendedor")
	private Funcionario funcionario;

}
