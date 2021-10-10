package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.DocumentoDto;

@Service
public interface DocumentoService {

	DocumentoDto save(DocumentoDto documentoDto) throws Exception;
	
	DocumentoDto findById(Integer id_documento) throws Exception;
	
	Boolean delete(Integer id_documento) throws Exception;
	
	List<DocumentoDto>findDocumentos() throws Exception;
}
