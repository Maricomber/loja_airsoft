package com.loja_airsoft.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

	private Integer idEndereco;
	private String dsRua;
	private Integer endNumero;
	private String endBairro;
	private String endCidade;
	private String endComplemento;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "end_id_endereco", nullable = false)
	public Integer getIdEndereco() {
		return idEndereco;
	}
	
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	@Column(name = "end_rua", nullable = false)
	public String getDsRua() {
		return dsRua;
	}
	
	public void setDsRua(String dsRua) {
		this.dsRua = dsRua;
	}
	
	@Column(name = "end_numero", nullable = false)
	public Integer getEndNumero() {
		return endNumero;
	}
	
	public void setEndNumero(Integer endNumero) {
		this.endNumero = endNumero;
	}
	
	@Column(name = "end_bairro", nullable = false)
	public String getEndBairro() {
		return endBairro;
	}
	
	public void setEndBairro(String endBairro) {
		this.endBairro = endBairro;
	}
	
	@Column(name = "end_cidade", nullable = false)
	public String getEndCidade() {
		return endCidade;
	}
	
	public void setEndCidade(String endCidade) {
		this.endCidade = endCidade;
	}
	
	@Column(name = "end_complemento", nullable = true)
	public String getEndComplemento() {
		return endComplemento;
	}
	
	public void setEndComplemento(String endComplemento) {
		this.endComplemento = endComplemento;
	}

}
