package com.loja_airsoft.app.dtos;


import com.loja_airsoft.app.entities.Documento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentoDto {

	private int idDocumento;
	private String dsDocumento;
	private UsuarioDto usuario;
	private TipoDocumentoDto tipoDocumento;
	
	public DocumentoDto() {
		
	}
	
	public DocumentoDto(Documento documento) {
		this.idDocumento = documento.getIdDocumento();
		this.dsDocumento = documento.getDsDocumento();
		this.usuario = new UsuarioDto(documento.getUsuario());
		this.tipoDocumento = new TipoDocumentoDto(documento.getTipoDocumento());
	}
}
