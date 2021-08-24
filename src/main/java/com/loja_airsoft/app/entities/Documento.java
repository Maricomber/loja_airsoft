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

import com.loja_airsoft.app.dtos.DocumentoDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "documento")
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doc_id_doc", nullable = false)
	private int idDocumento;
	
	@Column(name = "doc_ds_doc", nullable = false)
	private String dsDocumento;
	
	@ManyToOne(cascade = CascadeType.MERGE)  
    @JoinColumn(name="usu_id_usuario", nullable = true)
	private Usuario usuario;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private TipoDocumento tipoDocumento;
	
	public Documento() {
		
	}
	
	public Documento (DocumentoDto documentoDto) {
		
		this.idDocumento = documentoDto.getIdDocumento();
		this.dsDocumento = documentoDto.getDsDocumento();
		this.usuario = new Usuario(documentoDto.getUsuario());
		this.tipoDocumento = new TipoDocumento(documentoDto.getTipoDocumento());
		
	}
}
