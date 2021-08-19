package com.loja_airsoft.app.entities;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@Column(name = "fun_cpf_vendedor", nullable = true)
	private BigInteger cpfFunc;
	
	@Column(name = "fun_dt_nascimento", nullable = false)
	private Date dtNascFun;
	
	@Column(name = "fun_ds_nome", nullable = false)
	private String nmFunc;
	
	@Column(name = "fun_dt_contratacao", nullable = false)
	private Date dtContFunc;
	
	@ManyToOne
    @JoinColumn(name="crg_id_cargo")
	private Cargo cargo;
	
	@OneToOne
    @JoinColumn(name = "end_id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "funcionario")
	private List<Telefone> telefone;
	

}
