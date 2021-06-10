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

import com.loja_airsoft.app.dtos.TelefoneDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.TelefoneService;

@Controller
public class TelefoneController {

	@Autowired
	TelefoneService telefoneService;
	
	@GetMapping(path = {"telefone/{id}"})
	public @ResponseBody ResponseEntity<Response<TelefoneDto>> findById(@PathVariable int id){
		
		Response<TelefoneDto>response = new Response<TelefoneDto>();
		TelefoneDto telefoneDto = new TelefoneDto();
		
		telefoneDto= this.telefoneService.findById(id);
		
		if(telefoneDto.equals(null)) {
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(telefoneDto);
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping("/updateTelefones")
	public @ResponseBody ResponseEntity<Response<TelefoneDto>> update(TelefoneDto telefoneDto){
		
		Response<TelefoneDto>response = new Response<TelefoneDto>();
		
		telefoneDto = this.telefoneService.save(telefoneDto);
			if(telefoneDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(telefoneDto);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/findTelefones")
	public @ResponseBody ResponseEntity<Response<List<TelefoneDto>>> findTelefones(HttpServletRequest request) {
		
		Response<List<TelefoneDto>> response = new Response<List<TelefoneDto>>();
		List<TelefoneDto>telefonesDto = this.telefoneService.findTelefones();
		
		if(telefonesDto.equals(null)) {
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(telefonesDto);
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/saveTelefone")
	public @ResponseBody ResponseEntity<Response<TelefoneDto>> saveTelefone(TelefoneDto telefoneDto) {
		
		Response<TelefoneDto> response = new Response<TelefoneDto>();
		
		if(telefoneDto.getIdTelefone() != null) {
			telefoneDto = this.telefoneService.save(telefoneDto);
			
			if(telefoneDto == null) {
				return ResponseEntity.badRequest().body(response);
			}
			response.setData(telefoneDto);
			return ResponseEntity.ok(response);
		}
		else {
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@DeleteMapping("/deleteTelefone")
	public @ResponseBody ResponseEntity<Response<TelefoneDto>> deleteTelefone(TelefoneDto telefoneDto) {
		
		Response<TelefoneDto> response = new Response<TelefoneDto>();
		
		if(telefoneDto.getIdTelefone() != null) {
			Boolean retorno = this.telefoneService.delete(telefoneDto);
	
			if(retorno == false || retorno == null) {
				return ResponseEntity.badRequest().body(response);
			}
			response.setData(telefoneDto);
			return ResponseEntity.ok(response);
		}
		else {
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	
}