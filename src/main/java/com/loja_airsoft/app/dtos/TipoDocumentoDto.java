package com.loja_airsoft.app.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.TipoDocumento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDocumentoDto {

	public int idTpDocumento;
	private String dsTpDocumento;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<DocumentoDto>documento;
	
	public TipoDocumentoDto() {
		
	}
	
	public TipoDocumentoDto(TipoDocumento tipoDocumento) {
		this.idTpDocumento = tipoDocumento.idTpDocumento;
		this.dsTpDocumento = tipoDocumento.getDsTpDocumento();
	}
}
