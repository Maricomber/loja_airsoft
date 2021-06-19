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

import com.loja_airsoft.app.dtos.TelefoneDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.TelefoneService;

@Controller
public class TelefoneController {

	@Autowired
	TelefoneService telefoneService;
	
	@GetMapping(path = {"/loja_airsoft/telefone/find/{id}"})
	public @ResponseBody ResponseEntity<Response<TelefoneDto>> findById(@PathVariable int id){
		
		Response<TelefoneDto>response = new Response<TelefoneDto>();
		TelefoneDto telefoneDto = new TelefoneDto();
		List<String>erros = new ArrayList<String>();
		
		try {
			telefoneDto= this.telefoneService.findById(id);
			
			if(telefoneDto.equals(null)) {
				throw new Exception("Erro ao buscar telefone. ");
			}
			response.setData(telefoneDto);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping("/loja_airsoft/telefone/update")
	public @ResponseBody ResponseEntity<Response<TelefoneDto>> update(@RequestBody TelefoneDto telefoneDto){
		
		Response<TelefoneDto>response = new Response<TelefoneDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			telefoneDto = this.telefoneService.save(telefoneDto);
			if(telefoneDto.equals(null)) {
				throw new Exception("Erro ao salvar telefone. ");
			}
		response.setData(telefoneDto);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/loja_airsoft/telefone/find")
	public @ResponseBody ResponseEntity<Response<List<TelefoneDto>>> findTelefones(HttpServletRequest request) {
		
		Response<List<TelefoneDto>> response = new Response<List<TelefoneDto>>();
		List<String>erros = new ArrayList<String>();
		
		try {
			List<TelefoneDto>telefonesDto = this.telefoneService.findTelefones();
			if(telefonesDto.equals(null)) {
				throw new Exception("Nenhum telefone foi encontrado. ");
			}
			response.setData(telefonesDto);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/loja_airsoft/telefone/save")
	public @ResponseBody ResponseEntity<Response<TelefoneDto>> saveTelefone(@RequestBody TelefoneDto telefoneDto) {
		
		Response<TelefoneDto> response = new Response<TelefoneDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			telefoneDto = this.telefoneService.save(telefoneDto);
			
			if(telefoneDto == null) {
				return ResponseEntity.badRequest().body(response);
			}
			response.setData(telefoneDto);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
			
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/loja_airsoft/telefone/delete/{id}")
	public @ResponseBody ResponseEntity<Response<TelefoneDto>> deleteTelefone(@PathVariable Integer id) {
		
		Response<TelefoneDto> response = new Response<TelefoneDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco");
			}
			this.telefoneService.delete(id);	
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
}