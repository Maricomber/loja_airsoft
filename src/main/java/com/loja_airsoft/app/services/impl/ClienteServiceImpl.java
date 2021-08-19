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
import com.loja_airsoft.app.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	
	private String msgErro;
	
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Override
	public ClienteDto save(ClienteDto clienteDto) throws Exception {
		
		try {
			Cliente cliente = clienteDto.toEntity();
			cliente.getTelefone().forEach(telefone -> telefone.setCliente(cliente));
			
			log.info("Salvando cliente");
			
			return new ClienteDto(this.clienteRepository.save(cliente));
		}catch (Exception e) {
			msgErro = "Erro ao salvar cliente "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public ClienteDto findById(Integer id_cliente) throws Exception {
		log.info("Buscando cliente.");
		Cliente cliente = new Cliente();
		try {
			cliente = this.clienteRepository.findByIdCliente(id_cliente);
			if(cliente == null) {
				log.info("Sem resultados.");
				return null;
			}
			log.info("cliente encontrado.");
			return new ClienteDto(cliente);
		}catch (Exception e) {
			msgErro = "Erro ao buscar cliente. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public Boolean delete(Integer idCliente) throws Exception {
		log.info("Deletando cliente");
		try{
			Cliente cliente = this.clienteRepository.findByIdCliente(idCliente);
			this.clienteRepository.delete(cliente);
		}catch (Exception e) {
			msgErro = "cliente não pode ser deletado "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
		return true;
	}

	@Override
	public List<ClienteDto> findClientes() throws Exception {
		log.info("Buscando todos os clientes");
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<ClienteDto> clientesRetorno = new ArrayList<ClienteDto>();
		
		try {
			clientes = this.clienteRepository.findAll();
			for(Cliente cliente: clientes) {
				clientesRetorno.add(new ClienteDto(cliente));
			}
			log.info("Busca realizada com sucesso");
			return clientesRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar clientes "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

}
