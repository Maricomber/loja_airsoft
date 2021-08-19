package com.loja_airsoft.app.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "crg_id_cargo", nullable = false)
	private Integer idCargo;
	
	@Column(name = "crg_ds_cargo", nullable = false, length = 100)
	private String dsCargo;
	
	@OneToMany(mappedBy="cargo")
	private List<Usuario> usuario;
}
