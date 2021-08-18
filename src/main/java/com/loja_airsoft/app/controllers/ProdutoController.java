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

import com.loja_airsoft.app.dtos.ProdutoDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.ProdutoService;

@RestController
@RequestMapping(path = {"/loja_airsoft/produto"})
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	
	@GetMapping(path = {"/{id}"})
	public @ResponseBody ResponseEntity<Response<ProdutoDto>> findById(@PathVariable Integer id){
		
		List<String>erros = new ArrayList<String>();
		Response<ProdutoDto>response = new Response<ProdutoDto>();
		ProdutoDto produtoDto = new ProdutoDto();
		
		try {
			
			if(id == null) {
				throw new Exception("Campos em branco");
			}
			
			produtoDto= this.produtoService.findById(id);
			
			if(produtoDto.equals(null)) {
				throw new Exception("Produto não encontrado. ");
			}
			response.setData(produtoDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Response<ProdutoDto>> update(@RequestBody ProdutoDto produtoDto){
		
		List<String>erros = new ArrayList<String>();
		Response<ProdutoDto>response = new Response<ProdutoDto>();
		
		try {
			produtoDto = this.produtoService.save(produtoDto);
			if(produtoDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(produtoDto);
		return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}

	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<Response<List<ProdutoDto>>> findProdutos(HttpServletRequest request) {
		
		Response<List<ProdutoDto>> response = new Response<List<ProdutoDto>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<ProdutoDto>produtosDto = this.produtoService.findProdutos();
			
			if(produtosDto.equals(null)) {
				throw new Exception("Produto não encontrado");
			}
			response.setData(produtosDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Response<ProdutoDto>> saveProduto(@RequestBody ProdutoDto produtoDto) {
		
		Response<ProdutoDto> response = new Response<ProdutoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {

			if(produtoDto == null) {
				throw new Exception("Campos vazios. ");
			}
			produtoDto = this.produtoService.save(produtoDto);
			response.setData(produtoDto);
			return ResponseEntity.ok(response);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Response<ProdutoDto>> deleteProduto(@PathVariable Integer id) {
		
		Response<ProdutoDto> response = new Response<ProdutoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			this.produtoService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
}
