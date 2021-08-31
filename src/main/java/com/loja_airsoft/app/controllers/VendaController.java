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

import com.loja_airsoft.app.dtos.VendaDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.VendaService;

@RestController
@RequestMapping(path = {"/loja_airsoft/venda"})
public class VendaController {

	@Autowired
	VendaService vendaService;
	
	
	@GetMapping(path = {"/{id}"})
	public @ResponseBody ResponseEntity<Response<VendaDto>> findById(@PathVariable Integer id){
		
		List<String>erros = new ArrayList<String>();
		Response<VendaDto>response = new Response<VendaDto>();
		VendaDto vendaDto;
		
		try {
			
			if(id == null) {
				throw new Exception("Campos em branco");
			}
			
			vendaDto= this.vendaService.findById(id);
			
			if(vendaDto.equals(null)) {
				throw new Exception("Venda não encontrado. ");
			}
			response.setData(vendaDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Response<VendaDto>> update(@RequestBody VendaDto vendaDto){
		
		List<String>erros = new ArrayList<String>();
		Response<VendaDto>response = new Response<VendaDto>();
		
		try {
			vendaDto = this.vendaService.save(vendaDto);
			if(vendaDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(vendaDto);
		return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}

	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<Response<List<VendaDto>>> findVendas(HttpServletRequest request) {
		
		Response<List<VendaDto>> response = new Response<List<VendaDto>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<VendaDto>vendasDto = this.vendaService.findVendas();
			
			if(vendasDto.equals(null)) {
				throw new Exception("Venda não encontrado");
			}
			response.setData(vendasDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Response<VendaDto>> saveVenda(@RequestBody VendaDto vendaDto) {
		
		Response<VendaDto> response = new Response<VendaDto>();
		List<String>erros = new ArrayList<String>();
		
		try {

			if(vendaDto == null) {
				throw new Exception("Campos vazios. ");
			}
			vendaDto = this.vendaService.save(vendaDto);
			response.setData(vendaDto);
			return ResponseEntity.ok(response);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Response<VendaDto>> deleteVenda(@PathVariable Integer id) {
		
		Response<VendaDto> response = new Response<VendaDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			this.vendaService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
}

