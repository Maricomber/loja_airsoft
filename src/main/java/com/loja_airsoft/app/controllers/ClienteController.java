package com.loja_airsoft.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loja_airsoft.app.dtos.ClienteDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.ClienteService;

@RestController
@RequestMapping(path = {"/loja_airsoft/cliente"})
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	
	@GetMapping(path = {"/{id}"})
	public @ResponseBody ResponseEntity<Response<ClienteDto>> findById(@PathVariable int id){
		
		List<String>erros = new ArrayList<String>();
		Response<ClienteDto>response = new Response<ClienteDto>();
		
		try {
			
			ClienteDto clienteDto = new ClienteDto();
			clienteDto= this.clienteService.findById(id);
			
			if(clienteDto == null) {
				throw new Exception ("Cliente não encontrado. ");
			}
			response.setData(clienteDto);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Response<ClienteDto>> update(@RequestBody ClienteDto clienteDto){
		
		List<String>erros = new ArrayList<String>();
		Response<ClienteDto>response = new Response<ClienteDto>();
		
		try {
			if(clienteDto == null) {
				throw new Exception("Campos em branco. ");
			}
			clienteDto = this.clienteService.save(clienteDto);
			if(clienteDto.equals(null)) {
				throw new Exception ("Cliente não encontrado. ");
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
	
	@GetMapping
	public @ResponseBody ResponseEntity<Response<List<ClienteDto>>> findClientes(HttpServletRequest request) {
		
		Response<List<ClienteDto>> response = new Response<List<ClienteDto>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<ClienteDto>clientesDto = this.clienteService.findClientes();
			if(clientesDto == null) {
				return ResponseEntity.badRequest().body(response);
			}
			response.setData(clientesDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
	}
		
	
	@PostMapping
	public @ResponseBody ResponseEntity<Response<ClienteDto>> saveCliente(@RequestBody ClienteDto clienteDto) {
		
		Response<ClienteDto>response = new Response<ClienteDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(clienteDto == null) {
				throw new Exception("Campos em branco");
			}
			clienteDto = this.clienteService.save(clienteDto);
			if(clienteDto == null) {
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
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Response<ClienteDto>> deleteCliente(@PathVariable Integer id) {
		List<String>erros = new ArrayList<String>();
		Response<ClienteDto> response = new Response<ClienteDto>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco");
			}
	
			this.clienteService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}	
}