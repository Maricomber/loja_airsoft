package com.loja_airsoft.app.dtos;

import java.util.List;

import com.loja_airsoft.app.entities.Documento;
import com.loja_airsoft.app.entities.TipoDocumento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDocumentoDto {

	public int idTpDocumento;
	private String dsTpDocumento;
	private List<Documento> documento;
	
	public TipoDocumentoDto() {
		
	}
	
	public TipoDocumentoDto(TipoDocumento tipoDocumento) {
		this.idTpDocumento = tipoDocumento.idTpDocumento;
		this.dsTpDocumento = tipoDocumento.getDsTpDocumento();
		tipoDocumento.getDocumento().forEach(documento -> this.documento.add(documento));
	}
}
