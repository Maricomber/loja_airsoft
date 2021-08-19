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

import com.loja_airsoft.app.dtos.PerfilDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.PerfilService;

@RestController
@RequestMapping(path = {"/loja_airsoft/perfil"})
public class PerfilController {

	@Autowired
	PerfilService perfilService;
	
	
	@GetMapping(path = {"/{id}"})
	public @ResponseBody ResponseEntity<Response<PerfilDto>> findById(@PathVariable Integer id){
		
		List<String>erros = new ArrayList<String>();
		Response<PerfilDto>response = new Response<PerfilDto>();
		PerfilDto perfilDto;
		
		try {
			
			if(id == null) {
				throw new Exception("Campos em branco");
			}
			
			perfilDto= this.perfilService.findById(id);
			
			if(perfilDto.equals(null)) {
				throw new Exception("Perfil não encontrado. ");
			}
			response.setData(perfilDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Response<PerfilDto>> update(@RequestBody PerfilDto perfilDto){
		
		List<String>erros = new ArrayList<String>();
		Response<PerfilDto>response = new Response<PerfilDto>();
		
		try {
			perfilDto = this.perfilService.save(perfilDto);
			if(perfilDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(perfilDto);
		return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}

	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<Response<List<PerfilDto>>> findPerfils(HttpServletRequest request) {
		
		Response<List<PerfilDto>> response = new Response<List<PerfilDto>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<PerfilDto>perfilsDto = this.perfilService.findPerfils();
			
			if(perfilsDto.equals(null)) {
				throw new Exception("Perfil não encontrado");
			}
			response.setData(perfilsDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Response<PerfilDto>> savePerfil(@RequestBody PerfilDto perfilDto) {
		
		Response<PerfilDto> response = new Response<PerfilDto>();
		List<String>erros = new ArrayList<String>();
		
		try {

			if(perfilDto == null) {
				throw new Exception("Campos vazios. ");
			}
			perfilDto = this.perfilService.save(perfilDto);
			response.setData(perfilDto);
			return ResponseEntity.ok(response);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Response<PerfilDto>> deletePerfil(@PathVariable Integer id) {
		
		Response<PerfilDto> response = new Response<PerfilDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			this.perfilService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
}