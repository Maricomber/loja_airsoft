package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.DocumentoDto;
import com.loja_airsoft.app.entities.Documento;
import com.loja_airsoft.app.repositories.DocumentoRepository;
import com.loja_airsoft.app.services.DocumentoService;

@Service
public class DocumentoServiceImpl implements DocumentoService {

	@Autowired
	DocumentoRepository documentoRepository;
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(DocumentoServiceImpl.class);
	
	@Override
	public DocumentoDto save(DocumentoDto documentoDto) throws Exception {
		
		if(documentoDto.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		log.info("Salvando documento");
		Documento documento = new Documento(documentoDto);
		
		try {
			documento = this.documentoRepository.save(documento);
			return new DocumentoDto(documento);
		}catch (Exception e) {
			msgErro = "Erro ao salvar documento. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
	

	@Override
	public DocumentoDto findById(Integer id_documento) throws Exception {
		log.info("Buscando documento.");
		Documento documento = new Documento();
		try {
			documento = this.documentoRepository.findByIdDocumento(id_documento);
			if(documento == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("Documento encontrado.");
			return new DocumentoDto(documento);
		}catch (Exception e) {
			msgErro = "Erro ao buscar documento. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer id_documento) throws Exception {
		
		Documento documento = new Documento();
		log.info("Deletando documento ");
		
		try{
			documento = this.documentoRepository.findByIdDocumento(id_documento);
			this.documentoRepository.delete(documento);
		}catch (Exception e) {;
			msgErro = "Erro documento não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<DocumentoDto> findDocumentos() throws Exception {
		log.info("Buscando todos os documentos");
		List<Documento> documentos = new ArrayList<Documento>();
		List<DocumentoDto> documentosRetorno = new ArrayList<DocumentoDto>();
		
		try {
			documentos = this.documentoRepository.findAll();
			for(Documento documento: documentos) {
				documentosRetorno.add(new DocumentoDto(documento));
			}
			log.info("Busca realizada com sucesso");
			return documentosRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar documentos. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
}