package com.loja_airsoft.app.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.Documento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentoDto {

	private int idDocumento;
	private String dsDocumento;

	private TipoDocumentoDto tipoDocumento;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private UsuarioDto usuario;
	
	public DocumentoDto() {
		
	}
	
	public DocumentoDto(Documento documento) {
		this.idDocumento = documento.getIdDocumento();
		//this.usuario = new UsuarioDto(documento.getUsuario());
		this.tipoDocumento = new TipoDocumentoDto(documento.getTipoDocumento());
		this.dsDocumento = documento.getDsDocumento();
	}
}
