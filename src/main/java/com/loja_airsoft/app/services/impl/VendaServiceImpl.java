package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.VendaDto;
import com.loja_airsoft.app.entities.Venda;
import com.loja_airsoft.app.repositories.VendaRepository;
import com.loja_airsoft.app.services.VendaService;

@Service
public class VendaServiceImpl implements VendaService{

	@Autowired
	VendaRepository vendaRepository;
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(VendaServiceImpl.class);
	
	@Override
	public VendaDto save(VendaDto vendaDto) throws Exception {
		
		log.info("Salvando venda");
		Venda venda;
		
		if(vendaDto.equals(null)) {
			throw new Exception("Pesquisa em branco. ");
		}
		try {
			
			venda = this.vendaRepository.save(new Venda(vendaDto));
			return new VendaDto(venda);
		}catch (Exception e) {
			msgErro = "Erro ao salvar venda. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public VendaDto findById(Integer id_venda) throws Exception {
		log.info("Buscando venda.");
		Venda venda = new Venda();
		try {
			venda = this.vendaRepository.findByidVenda(id_venda);
			if(venda == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("venda encontrado.");
			return new VendaDto(venda);
		}catch (Exception e) {
			msgErro = "Erro ao buscar venda."+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer id_venda) throws Exception {
		Venda venda = new Venda();
		log.info("Deletando venda");
		
		try{
			venda = this.vendaRepository.findByidVenda(id_venda);
			this.vendaRepository.delete(venda);
		}catch (Exception e) {
			msgErro = "venda não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<VendaDto> findVendas() throws Exception {
		log.info("Buscando todos os vendas");
		List<Venda> vendas = new ArrayList<Venda>();
		List<VendaDto> vendaDto = new ArrayList<VendaDto>();
		
		try {
			vendas = this.vendaRepository.findAll();
			log.info("Busca realizada com sucesso");
			
			vendas.forEach(venda -> vendaDto.add(new VendaDto (venda)));
			
			return vendaDto;
		}catch (Exception e) {
			msgErro = "Erro ao buscar vendas. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

}
