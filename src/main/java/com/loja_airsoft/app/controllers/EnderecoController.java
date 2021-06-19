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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loja_airsoft.app.dtos.EnderecoDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.EnderecoService;

@Controller
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping(path = {"/loja_airsoft/endereco/find/{id}"})
	public @ResponseBody ResponseEntity<Response<EnderecoDto>> findById(@PathVariable int id){
		
		List<String>erros = new ArrayList<String>();
		Response<EnderecoDto>response = new Response<EnderecoDto>();
		EnderecoDto enderecoDto = new EnderecoDto();
		
		try {
			enderecoDto= this.enderecoService.findById(id);
			
			if(enderecoDto.equals(null)) {
				throw new Exception("Endereço não encontrado. ");
			}
			response.setData(enderecoDto);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/loja_airsoft/endereco/update")
	public @ResponseBody ResponseEntity<Response<EnderecoDto>> update(@RequestBody EnderecoDto enderecoDto){
		
		Response<EnderecoDto>response = new Response<EnderecoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			enderecoDto = this.enderecoService.save(enderecoDto);
			if(enderecoDto.equals(null)) {
				throw new Exception("Erro ao atualizar endereço. ");
			}
		response.setData(enderecoDto);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/loja_airsoft/endereco/find")
	public @ResponseBody ResponseEntity<Response<List<EnderecoDto>>> findEnderecos(HttpServletRequest request) {
		
		Response<List<EnderecoDto>> response = new Response<List<EnderecoDto>>();
		List<String>erros = new ArrayList<String>();
		
		try {
			List<EnderecoDto>enderecosDto = this.enderecoService.findEnderecos();
			
			if(enderecosDto.equals(null)) {
				throw new Exception("Não foi encontrado nenhum endereço. ");
			}
			response.setData(enderecosDto);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/loja_airsoft/endereco/save")
	public @ResponseBody ResponseEntity<Response<EnderecoDto>> saveEndereco(@RequestBody EnderecoDto enderecoDto) {
		
		Response<EnderecoDto> response = new Response<EnderecoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(enderecoDto == null) {
				throw new Exception("Campos em branco. ");
			}
			enderecoDto = this.enderecoService.save(enderecoDto);
			
			if(enderecoDto == null) {
				throw new Exception("Erro ao salvar endereço. ");
			}
			response.setData(enderecoDto);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/loja_airsoft/endereco/delete/{id}")
	public @ResponseBody ResponseEntity<Response<EnderecoDto>> deleteEndereco(@PathVariable Integer id) {
		
		Response<EnderecoDto> response = new Response<EnderecoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			this.enderecoService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
	}
	
	
}