package com.loja_airsoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.VendaDto;

@Service
public interface VendaService {

	VendaDto save(VendaDto vendaDto) throws Exception;
	
	VendaDto findById(Integer idVenda) throws Exception;
	
	Boolean delete(Integer idVenda) throws Exception;
	
	List<VendaDto>findVendas() throws Exception;
}
