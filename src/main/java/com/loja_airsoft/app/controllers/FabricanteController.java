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

import com.loja_airsoft.app.dtos.FabricanteDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.FabricanteService;

@Controller
public class FabricanteController {
	
	@Autowired
	FabricanteService fabricanteService;
	
	
	@GetMapping(path = {"/loja_airsoft/fabricante/find/{id}"})
	public @ResponseBody ResponseEntity<Response<FabricanteDto>> findById(@PathVariable int id){
		
		List<String>erros = new ArrayList<String>();
		Response<FabricanteDto>response = new Response<FabricanteDto>();
		
		try {
			
			FabricanteDto fabricanteDto = new FabricanteDto();
			fabricanteDto= this.fabricanteService.findById(id);
			
			if(fabricanteDto == null) {
				throw new Exception ("Fabricante não encontrado. ");
			}
			response.setData(fabricanteDto);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/loja_airsoft/fabricante/update")
	public @ResponseBody ResponseEntity<Response<FabricanteDto>> update(@RequestBody FabricanteDto fabricanteDto){
		
		List<String>erros = new ArrayList<String>();
		Response<FabricanteDto>response = new Response<FabricanteDto>();
		
		try {
			if(fabricanteDto == null) {
				throw new Exception("Campos em branco. ");
			}
			fabricanteDto = this.fabricanteService.save(fabricanteDto);
			if(fabricanteDto.equals(null)) {
				throw new Exception ("Fabricante não encontrado. ");
			}
		response.setData(fabricanteDto);
		}
		catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/loja_airsoft/fabricante/find")
	public @ResponseBody ResponseEntity<Response<List<FabricanteDto>>> findFabricantes(HttpServletRequest request) {
		
		Response<List<FabricanteDto>> response = new Response<List<FabricanteDto>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<FabricanteDto>fabricanteDto = this.fabricanteService.findFabricantes();
			if(fabricanteDto == null) {
				return ResponseEntity.badRequest().body(response);
			}
			response.setData(fabricanteDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
	}
		
	
	@PostMapping("/loja_airsoft/fabricante/save")
	public @ResponseBody ResponseEntity<Response<FabricanteDto>> saveFabricante(@RequestBody FabricanteDto fabricanteDto) {
		
		Response<FabricanteDto>response = new Response<FabricanteDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(fabricanteDto == null) {
				throw new Exception("Campos em branco");
			}
			fabricanteDto = this.fabricanteService.save(fabricanteDto);
			if(fabricanteDto == null) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(fabricanteDto);
		}
		catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/loja_airsoft/fabricante/delete/{id}")
	public @ResponseBody ResponseEntity<Response<FabricanteDto>> deleteFabricante(@PathVariable Integer id) {
		List<String>erros = new ArrayList<String>();
		Response<FabricanteDto> response = new Response<FabricanteDto>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco");
			}
	
			this.fabricanteService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}	
}
