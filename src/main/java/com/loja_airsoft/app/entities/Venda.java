package com.loja_airsoft.app.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.loja_airsoft.app.dtos.VendaDto;

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
	
	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
	private List<Produto> produto = new ArrayList<Produto>();
	
	public Venda() {
		
	}
	
	public Venda(VendaDto venda) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dtVenda = dateFormat.parse(venda.getDtVenda());
			this.idVenda = venda.getIdVenda();
			this.vlDesconto = venda.getVlDesconto();
			this.vlTotal = venda.getVlTotal();
			
			if(!(venda.getCliente()== null)) {
				this.cliente = new Usuario(venda.getCliente());
			}
			if(!(venda.getVendedor() == null)) {
				this.vendedor = new Usuario(venda.getVendedor());
			}
			venda.getProdutoDto().forEach(produto -> this.produto.add(new Produto(produto)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
