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

import com.loja_airsoft.app.dtos.TipoDocumentoDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.TipoDocumentoService;

@RestController
@RequestMapping(path = {"/loja_airsoft/tipo_documento"})
public class TipoDocumentoController {

	@Autowired
	TipoDocumentoService tipoDocumentoService;
	
	
	@GetMapping(path = {"/{id}"})
	public @ResponseBody ResponseEntity<Response<TipoDocumentoDto>> findById(@PathVariable Integer id){
		
		List<String>erros = new ArrayList<String>();
		Response<TipoDocumentoDto>response = new Response<TipoDocumentoDto>();
		TipoDocumentoDto tipoDocumentoDto;
		
		try {
			
			if(id == null) {
				throw new Exception("Campos em branco");
			}
			
			tipoDocumentoDto= this.tipoDocumentoService.findById(id);
			
			if(tipoDocumentoDto.equals(null)) {
				throw new Exception("TipoDocumento não encontrado. ");
			}
			response.setData(tipoDocumentoDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Response<TipoDocumentoDto>> update(@RequestBody TipoDocumentoDto tipoDocumentoDto){
		
		List<String>erros = new ArrayList<String>();
		Response<TipoDocumentoDto>response = new Response<TipoDocumentoDto>();
		
		try {
			tipoDocumentoDto = this.tipoDocumentoService.save(tipoDocumentoDto);
			if(tipoDocumentoDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(tipoDocumentoDto);
		return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}

	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<Response<List<TipoDocumentoDto>>> findTipoDocumentos(HttpServletRequest request) {
		
		Response<List<TipoDocumentoDto>> response = new Response<List<TipoDocumentoDto>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<TipoDocumentoDto>tipoDocumentosDto = this.tipoDocumentoService.findTipoDocumentos();
			
			if(tipoDocumentosDto.equals(null)) {
				throw new Exception("TipoDocumento não encontrado");
			}
			response.setData(tipoDocumentosDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Response<TipoDocumentoDto>> saveTipoDocumento(@RequestBody TipoDocumentoDto tipoDocumentoDto) {
		
		Response<TipoDocumentoDto> response = new Response<TipoDocumentoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {

			if(tipoDocumentoDto == null) {
				throw new Exception("Campos vazios. ");
			}
			tipoDocumentoDto = this.tipoDocumentoService.save(tipoDocumentoDto);
			response.setData(tipoDocumentoDto);
			return ResponseEntity.ok(response);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Response<TipoDocumentoDto>> deleteTipoDocumento(@PathVariable Integer id) {
		
		Response<TipoDocumentoDto> response = new Response<TipoDocumentoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			this.tipoDocumentoService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
}
