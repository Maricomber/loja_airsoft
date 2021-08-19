package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.loja_airsoft.app.dtos.TipoDocumentoDto;
import com.loja_airsoft.app.entities.TipoDocumento;
import com.loja_airsoft.app.repositories.TipoDocumentoRepository;
import com.loja_airsoft.app.services.TipoDocumentoService;

public class TipoDocumentoServiceImpl implements TipoDocumentoService{

	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(TipoDocumentoServiceImpl.class);
	
	@Override
	public TipoDocumentoDto save(TipoDocumentoDto tipoDocumentoDto) throws Exception {
		
		if(tipoDocumentoDto.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		log.info("Salvando tipoDocumento");
		TipoDocumento tipoDocumento = new TipoDocumento(tipoDocumentoDto);
		
		try {
			tipoDocumento = this.tipoDocumentoRepository.save(tipoDocumento);
			return new TipoDocumentoDto(tipoDocumento);
		}catch (Exception e) {
			msgErro = "Erro ao salvar tipoDocumento. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
	

	@Override
	public TipoDocumentoDto findById(Integer id_tipoDocumento) throws Exception {
		log.info("Buscando tipoDocumento.");
		TipoDocumento tipoDocumento = new TipoDocumento();
		try {
			tipoDocumento = this.tipoDocumentoRepository.findByIdTipoDocumento(id_tipoDocumento);
			if(tipoDocumento == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("TipoDocumento encontrado.");
			return new TipoDocumentoDto(tipoDocumento);
		}catch (Exception e) {
			msgErro = "Erro ao buscar tipoDocumento. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer id_tipoDocumento) throws Exception {
		
		TipoDocumento tipoDocumento = new TipoDocumento();
		log.info("Deletando tipoDocumento ");
		
		try{
			tipoDocumento = this.tipoDocumentoRepository.findByIdTipoDocumento(id_tipoDocumento);
			this.tipoDocumentoRepository.delete(tipoDocumento);
		}catch (Exception e) {;
			msgErro = "Erro tipoDocumento não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<TipoDocumentoDto> findTipoDocumentos() throws Exception {
		log.info("Buscando todos os tipoDocumentos");
		List<TipoDocumento> tipoDocumentos = new ArrayList<TipoDocumento>();
		List<TipoDocumentoDto> tipoDocumentosRetorno = new ArrayList<TipoDocumentoDto>();
		
		try {
			tipoDocumentos = this.tipoDocumentoRepository.findAll();
			for(TipoDocumento tipoDocumento: tipoDocumentos) {
				tipoDocumentosRetorno.add(new TipoDocumentoDto(tipoDocumento));
			}
			log.info("Busca realizada com sucesso");
			return tipoDocumentosRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar tipoDocumentos. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}
}