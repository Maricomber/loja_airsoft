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

import com.loja_airsoft.app.dtos.ProdutoTipoDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.ProdutoTipoService;

@RestController
@RequestMapping(path = {"/loja_airsoft/produto_tipo"})
public class ProdutoTipoController {

	@Autowired
	ProdutoTipoService produtoTipoService;
	
	
	@GetMapping(path = {"/{id}"})
	public @ResponseBody ResponseEntity<Response<ProdutoTipoDto>> findById(@PathVariable Integer id){
		
		List<String>erros = new ArrayList<String>();
		Response<ProdutoTipoDto>response = new Response<ProdutoTipoDto>();
		ProdutoTipoDto produtoTipoDto = new ProdutoTipoDto();
		
		try {
			
			if(id == null) {
				throw new Exception("Campos em branco");
			}
			
			produtoTipoDto= this.produtoTipoService.findById(id);
			
			if(produtoTipoDto.equals(null)) {
				throw new Exception("ProdutoTipo não encontrado. ");
			}
			response.setData(produtoTipoDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Response<ProdutoTipoDto>> update(@RequestBody ProdutoTipoDto produtoTipoDto){
		
		List<String>erros = new ArrayList<String>();
		Response<ProdutoTipoDto>response = new Response<ProdutoTipoDto>();
		
		try {
			produtoTipoDto = this.produtoTipoService.save(produtoTipoDto);
			if(produtoTipoDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(produtoTipoDto);
		return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}

	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<Response<List<ProdutoTipoDto>>> findProdutoTipos(HttpServletRequest request) {
		
		Response<List<ProdutoTipoDto>> response = new Response<List<ProdutoTipoDto>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<ProdutoTipoDto>produtoTiposDto = this.produtoTipoService.findProdutoTipos();
			
			if(produtoTiposDto.equals(null)) {
				throw new Exception("ProdutoTipo não encontrado");
			}
			response.setData(produtoTiposDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Response<ProdutoTipoDto>> saveProdutoTipo(@RequestBody ProdutoTipoDto produtoTipoDto) {
		
		Response<ProdutoTipoDto> response = new Response<ProdutoTipoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {

			if(produtoTipoDto == null) {
				throw new Exception("Campos vazios. ");
			}
			produtoTipoDto = this.produtoTipoService.save(produtoTipoDto);
			response.setData(produtoTipoDto);
			return ResponseEntity.ok(response);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Response<ProdutoTipoDto>> deleteProdutoTipo(@PathVariable Integer id) {
		
		Response<ProdutoTipoDto> response = new Response<ProdutoTipoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			this.produtoTipoService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
}
