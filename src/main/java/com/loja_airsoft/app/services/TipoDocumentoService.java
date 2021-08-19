package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.TipoDocumentoDto;

@Service
public interface TipoDocumentoService {
	
	TipoDocumentoDto save(TipoDocumentoDto tipoDocumentoDto) throws Exception;
	
	TipoDocumentoDto findById(Integer idTipoDocumento) throws Exception;
	
	Boolean delete(Integer idTipoDocumento) throws Exception;
	
	List<TipoDocumentoDto>findTipoDocumentos() throws Exception;
	
}
