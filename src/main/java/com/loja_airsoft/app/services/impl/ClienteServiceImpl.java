package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.ClienteDto;
import com.loja_airsoft.app.entities.Cliente;
import com.loja_airsoft.app.repositories.ClienteRepository;
import com.loja_airsoft.app.repositories.EnderecoRepository;
import com.loja_airsoft.app.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Override
	public ClienteDto save(ClienteDto clienteDto) throws Exception {
		
		if(clienteDto.equals(null)){
			throw new Exception("Pesquisa em branco");
		}
		log.info("Salvando cliente");
		Cliente cliente = new Cliente();
		try {
			cliente = this.clienteRepository.save(ClienteDto.toEntity(clienteDto));
			return  ClienteDto.fromEntity(cliente);
		}catch (Exception e) {
			log.info("Erro ao salvar cliente");
			return null;
		}
	}

	@Override
	public ClienteDto findById(Integer id_cliente) {
		log.info("Buscando cliente.");
		Cliente cliente = new Cliente();
		try {
			cliente = this.clienteRepository.findByIdCliente(id_cliente);
			if(cliente == null) {
				log.info("Sem resultados.");
				return null;
			}
			log.info("cliente encontrado.");
			return ClienteDto.fromEntity(cliente);
		}catch (Exception e) {
			log.info("Erro ao buscar cliente.");
			return null;
		}
	}

	@Override
	public Boolean delete(ClienteDto clienteDto) {
		log.info("Deletando cliente");
		try{
			this.clienteRepository.delete(ClienteDto.toEntity(clienteDto));
			return true;
		}catch (Exception e) {
			log.info("cliente não pode ser deletado");
		}
		return false;
	}

	@Override
	public List<ClienteDto> findClientes() {
		log.info("Buscando todos os clientes");
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<ClienteDto> clientesRetorno = new ArrayList<ClienteDto>();
		
		try {
			clientes = this.clienteRepository.findAll();
			for(Cliente cliente: clientes) {
				clientesRetorno.add(ClienteDto.fromEntity(cliente));
			}
			log.info("Busca realizada com sucesso");
			return clientesRetorno;
		}catch (Exception e) {
			log.info("Erro ao buscar clientes");
			return null;
		}
	}

}
