package com.loja_airsoft.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loja_airsoft.app.dtos.ClienteDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping(path = {"cliente/{id}"})
	public @ResponseBody ResponseEntity<Response<ClienteDto>> findById(@PathVariable int id){
		
		Response<ClienteDto>response = new Response<ClienteDto>();
		ClienteDto clienteDto = new ClienteDto();
		
		clienteDto= this.clienteService.findById(id);
		
		if(clienteDto.equals(null)) {
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(clienteDto);
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping("updateClientes")
	public @ResponseBody ResponseEntity<Response<ClienteDto>> update(ClienteDto clienteDto){
		List<String>erros = new ArrayList<String>();
		
		Response<ClienteDto>response = new Response<ClienteDto>();
		try {
			clienteDto = this.clienteService.save(clienteDto);
			if(clienteDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(clienteDto);
		}
		catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("findClientes")
	public @ResponseBody ResponseEntity<Response<List<ClienteDto>>> findClientes(HttpServletRequest request) {
		
		Response<List<ClienteDto>> response = new Response<List<ClienteDto>>();
		List<ClienteDto>clientesDto = this.clienteService.findClientes();
		
		if(clientesDto.equals(null)) {
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(clientesDto);
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("saveCliente")
	public @ResponseBody ResponseEntity<Response<ClienteDto>> saveCliente(ClienteDto clienteDto) {
		
List<String>erros = new ArrayList<String>();
		
		Response<ClienteDto>response = new Response<ClienteDto>();
		try {
			clienteDto = this.clienteService.save(clienteDto);
			if(clienteDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(clienteDto);
		}
		catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("deleteCliente/{id}")
	public @ResponseBody ResponseEntity<Response<ClienteDto>> deleteCliente(@PathVariable Integer id) {
		
		Response<ClienteDto> response = new Response<ClienteDto>();
		
		ClienteDto clienteDto = new ClienteDto();
		
		if(id != null) {
			clienteDto = this.clienteService.findById(id);
			Boolean retorno = this.clienteService.delete(clienteDto);
	
			if(retorno == false || retorno == null) {
				return ResponseEntity.badRequest().body(response);
			}
			
			return ResponseEntity.ok(response);
		}
		else {
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	
}