package com.loja_airsoft.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {
	private Integer id_cargo;
	private String ds_cargo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "crg_id_cargo", nullable = false)
	public Integer getIdCargo() {
		return id_cargo;
	}
	
	public void setIdCargo(Integer id_cargo) {
		this.id_cargo = id_cargo;
	}

	@Column(name = "crg_ds_cargo", nullable = false)
	public String getDsCargo() {
		return ds_cargo;
	}

	public void setDsCargo(String ds_cargo) {
		this.ds_cargo = ds_cargo;
	}

}
