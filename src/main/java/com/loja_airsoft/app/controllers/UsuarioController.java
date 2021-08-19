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

import com.loja_airsoft.app.dtos.UsuarioDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.UsuarioService;

@RestController
@RequestMapping(path = {"/loja_airsoft/usuario"})
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	
	@GetMapping(path = {"/{id}"})
	public @ResponseBody ResponseEntity<Response<UsuarioDto>> findById(@PathVariable Integer id){
		
		List<String>erros = new ArrayList<String>();
		Response<UsuarioDto>response = new Response<UsuarioDto>();
		UsuarioDto usuarioDto;
		
		try {
			
			if(id == null) {
				throw new Exception("Campos em branco");
			}
			
			usuarioDto= this.usuarioService.findById(id);
			
			if(usuarioDto.equals(null)) {
				throw new Exception("Usuario não encontrado. ");
			}
			response.setData(usuarioDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Response<UsuarioDto>> update(@RequestBody UsuarioDto usuarioDto){
		
		List<String>erros = new ArrayList<String>();
		Response<UsuarioDto>response = new Response<UsuarioDto>();
		
		try {
			usuarioDto = this.usuarioService.save(usuarioDto);
			if(usuarioDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(usuarioDto);
		return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}

	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<Response<List<UsuarioDto>>> findUsuarios(HttpServletRequest request) {
		
		Response<List<UsuarioDto>> response = new Response<List<UsuarioDto>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<UsuarioDto>usuariosDto = this.usuarioService.findUsuarios();
			
			if(usuariosDto.equals(null)) {
				throw new Exception("Usuario não encontrado");
			}
			response.setData(usuariosDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Response<UsuarioDto>> saveUsuario(@RequestBody UsuarioDto usuarioDto) {
		
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		List<String>erros = new ArrayList<String>();
		
		try {

			if(usuarioDto == null) {
				throw new Exception("Campos vazios. ");
			}
			usuarioDto = this.usuarioService.save(usuarioDto);
			response.setData(usuarioDto);
			return ResponseEntity.ok(response);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Response<UsuarioDto>> deleteUsuario(@PathVariable Integer id) {
		
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			this.usuarioService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
}