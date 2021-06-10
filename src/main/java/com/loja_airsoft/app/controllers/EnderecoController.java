package com.loja_airsoft.app.controllers;

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

import com.loja_airsoft.app.dtos.EnderecoDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.EnderecoService;

@Controller
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping(path = {"endereco/{id}"})
	public @ResponseBody ResponseEntity<Response<EnderecoDto>> findById(@PathVariable int id){
		
		Response<EnderecoDto>response = new Response<EnderecoDto>();
		EnderecoDto enderecoDto = new EnderecoDto();
		
		enderecoDto= this.enderecoService.findById(id);
		
		if(enderecoDto.equals(null)) {
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(enderecoDto);
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping("/updateEnderecos")
	public @ResponseBody ResponseEntity<Response<EnderecoDto>> update(EnderecoDto enderecoDto){
		
		Response<EnderecoDto>response = new Response<EnderecoDto>();
		
		enderecoDto = this.enderecoService.save(enderecoDto);
			if(enderecoDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(enderecoDto);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/findEnderecos")
	public @ResponseBody ResponseEntity<Response<List<EnderecoDto>>> findEnderecos(HttpServletRequest request) {
		
		Response<List<EnderecoDto>> response = new Response<List<EnderecoDto>>();
		List<EnderecoDto>enderecosDto = this.enderecoService.findEnderecos();
		
		if(enderecosDto.equals(null)) {
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(enderecosDto);
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/saveEndereco")
	public @ResponseBody ResponseEntity<Response<EnderecoDto>> saveEndereco(EnderecoDto enderecoDto) {
		
		Response<EnderecoDto> response = new Response<EnderecoDto>();
		
		if(enderecoDto.getIdEndereco() != null) {
			enderecoDto = this.enderecoService.save(enderecoDto);
			
			if(enderecoDto == null) {
				return ResponseEntity.badRequest().body(response);
			}
			response.setData(enderecoDto);
			return ResponseEntity.ok(response);
		}
		else {
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@DeleteMapping("/deleteEndereco")
	public @ResponseBody ResponseEntity<Response<EnderecoDto>> deleteEndereco(EnderecoDto enderecoDto) {
		
		Response<EnderecoDto> response = new Response<EnderecoDto>();
		
		if(enderecoDto.getIdEndereco() != null) {
			Boolean retorno = this.enderecoService.delete(enderecoDto);
	
			if(retorno == false || retorno == null) {
				return ResponseEntity.badRequest().body(response);
			}
			response.setData(enderecoDto);
			return ResponseEntity.ok(response);
		}
		else {
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	
}