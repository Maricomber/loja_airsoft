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

import com.loja_airsoft.app.dtos.DocumentoDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.DocumentoService;

@RestController
@RequestMapping(path = {"/loja_airsoft/documento"})
public class DocumentoController {

	@Autowired
	DocumentoService documentoService;
	
	
	@GetMapping(path = {"/{id}"})
	public @ResponseBody ResponseEntity<Response<DocumentoDto>> findById(@PathVariable Integer id){
		
		List<String>erros = new ArrayList<String>();
		Response<DocumentoDto>response = new Response<DocumentoDto>();
		DocumentoDto documentoDto;
		
		try {
			
			if(id == null) {
				throw new Exception("Campos em branco");
			}
			
			documentoDto= this.documentoService.findById(id);
			
			if(documentoDto.equals(null)) {
				throw new Exception("Documento não encontrado. ");
			}
			response.setData(documentoDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Response<DocumentoDto>> update(@RequestBody DocumentoDto documentoDto){
		
		List<String>erros = new ArrayList<String>();
		Response<DocumentoDto>response = new Response<DocumentoDto>();
		
		try {
			documentoDto = this.documentoService.save(documentoDto);
			if(documentoDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(documentoDto);
		return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}

	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<Response<List<DocumentoDto>>> findDocumentos(HttpServletRequest request) {
		
		Response<List<DocumentoDto>> response = new Response<List<DocumentoDto>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<DocumentoDto>documentosDto = this.documentoService.findDocumentos();
			
			if(documentosDto.equals(null)) {
				throw new Exception("Documento não encontrado");
			}
			response.setData(documentosDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Response<DocumentoDto>> saveDocumento(@RequestBody DocumentoDto documentoDto) {
		
		Response<DocumentoDto> response = new Response<DocumentoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {

			if(documentoDto == null) {
				throw new Exception("Campos vazios. ");
			}
			documentoDto = this.documentoService.save(documentoDto);
			response.setData(documentoDto);
			return ResponseEntity.ok(response);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Response<DocumentoDto>> deleteDocumento(@PathVariable Integer id) {
		
		Response<DocumentoDto> response = new Response<DocumentoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			this.documentoService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
}
