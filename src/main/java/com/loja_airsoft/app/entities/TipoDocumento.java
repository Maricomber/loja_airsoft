package com.loja_airsoft.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.loja_airsoft.app.dtos.TipoDocumentoDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_documento")
public class TipoDocumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tip_id_doc", nullable = false)
	public int idTpDocumento;
	
	@Column(name = "tip_ds_doc", nullable = false, length = 100)
	private String dsTpDocumento;
	
	@OneToMany(mappedBy="tipoDocumento", cascade = CascadeType.ALL)
	private List<Documento> documento = new ArrayList<Documento>();
	
	public TipoDocumento() {
		
	}
	
	public TipoDocumento(TipoDocumentoDto tipoDocumentoDto) {
		this.idTpDocumento = tipoDocumentoDto.getIdTpDocumento();
		this.dsTpDocumento = tipoDocumentoDto.getDsTpDocumento();
		
		if(!(tipoDocumentoDto.getDocumento() == null)) {
			tipoDocumentoDto.getDocumento().forEach(documento -> this.documento.add(new Documento(documento)));
		}
	}
	
}
