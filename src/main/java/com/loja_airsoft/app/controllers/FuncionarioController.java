package com.loja_airsoft.app.controllers;

import java.math.BigInteger;
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

import com.loja_airsoft.app.dtos.FuncionarioDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.FuncionarioService;

@RestController
@RequestMapping(path = {"/loja_airsoft/funcionario"})
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;
	
	
	@GetMapping(path = {"/{id}"})
	public @ResponseBody ResponseEntity<Response<FuncionarioDto>> findById(@PathVariable BigInteger id){
		
		List<String>erros = new ArrayList<String>();
		Response<FuncionarioDto>response = new Response<FuncionarioDto>();
		FuncionarioDto funcionarioDto;
		
		try {
			
			if(id == null) {
				throw new Exception("Campos em branco");
			}
			
			funcionarioDto= this.funcionarioService.findById(id);
			
			if(funcionarioDto.equals(null)) {
				throw new Exception("Funcionario não encontrado. ");
			}
			response.setData(funcionarioDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Response<FuncionarioDto>> update(@RequestBody FuncionarioDto funcionarioDto){
		
		List<String>erros = new ArrayList<String>();
		Response<FuncionarioDto>response = new Response<FuncionarioDto>();
		
		try {
			funcionarioDto = this.funcionarioService.save(funcionarioDto);
			if(funcionarioDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(funcionarioDto);
		return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}

	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<Response<List<FuncionarioDto>>> findFuncionarios(HttpServletRequest request) {
		
		Response<List<FuncionarioDto>> response = new Response<List<FuncionarioDto>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<FuncionarioDto>funcionariosDto = this.funcionarioService.findFuncionarios();
			
			if(funcionariosDto.equals(null)) {
				throw new Exception("Funcionario não encontrado");
			}
			response.setData(funcionariosDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Response<FuncionarioDto>> saveFuncionario(@RequestBody FuncionarioDto funcionarioDto) {
		
		Response<FuncionarioDto> response = new Response<FuncionarioDto>();
		List<String>erros = new ArrayList<String>();
		
		try {

			if(funcionarioDto == null) {
				throw new Exception("Campos vazios. ");
			}
			funcionarioDto = this.funcionarioService.save(funcionarioDto);
			response.setData(funcionarioDto);
			return ResponseEntity.ok(response);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Response<FuncionarioDto>> deleteFuncionario(@PathVariable BigInteger id) {
		
		Response<FuncionarioDto> response = new Response<FuncionarioDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			this.funcionarioService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
		
}
