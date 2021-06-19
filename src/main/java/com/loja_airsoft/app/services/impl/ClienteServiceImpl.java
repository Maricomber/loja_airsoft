package com.loja_airsoft.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_airsoft.app.dtos.ClienteDto;
import com.loja_airsoft.app.entities.Cliente;
import com.loja_airsoft.app.entities.Telefone;
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
		
		Cliente cliente = new Cliente();
		List<Telefone> telefoneLst = new ArrayList<Telefone>();
		
		try {
			cliente = ClienteDto.toEntity(clienteDto);
			for(Telefone telefone: cliente.getTelefone()) {
				telefone.setCliente(cliente);
				telefoneLst.add(telefone);
			}
			cliente.setTelefone(telefoneLst);
			
			log.info("Salvando cliente");
			cliente = this.clienteRepository.save(cliente);
			clienteDto = ClienteDto.fromEntity(cliente);
			
			return clienteDto;
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
			return ClienteDto.fromEntity(cliente);
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
				clientesRetorno.add(ClienteDto.fromEntity(cliente));
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
