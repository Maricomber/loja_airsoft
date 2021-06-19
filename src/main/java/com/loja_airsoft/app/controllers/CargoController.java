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

import com.loja_airsoft.app.dtos.CargoDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.CargoService;

@Controller
public class CargoController {

	@Autowired
	CargoService cargoService;
	
	
	@GetMapping(path = {"/loja_airsoft/cargo/find/{id}"})
	public @ResponseBody ResponseEntity<Response<CargoDto>> findById(@PathVariable int id){
		
		List<String>erros = new ArrayList<String>();
		Response<CargoDto>response = new Response<CargoDto>();
		CargoDto cargoDto = new CargoDto();
		
		try {
			cargoDto= this.cargoService.findById(id);
			
			if(cargoDto.equals(null)) {
				throw new Exception("Cargo não encontrado. ");
			}
			response.setData(cargoDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PutMapping("/loja_airsoft/cargo/update")
	public @ResponseBody ResponseEntity<Response<CargoDto>> update(@RequestBody CargoDto cargoDto){
		
		List<String>erros = new ArrayList<String>();
		Response<CargoDto>response = new Response<CargoDto>();
		
		try {
			cargoDto = this.cargoService.save(cargoDto);
			if(cargoDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(cargoDto);
		return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}

	}
	
	@GetMapping("/loja_airsoft/cargo/find")
	public @ResponseBody ResponseEntity<Response<List<CargoDto>>> findCargos(HttpServletRequest request) {
		
		Response<List<CargoDto>> response = new Response<List<CargoDto>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<CargoDto>cargosDto = this.cargoService.findCargos();
			
			if(cargosDto.equals(null)) {
				throw new Exception("Cargo não encontrado");
			}
			response.setData(cargosDto);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@PostMapping("/loja_airsoft/cargo/save")
	public @ResponseBody ResponseEntity<Response<CargoDto>> saveCargo(@RequestBody CargoDto cargoDto) {
		
		Response<CargoDto> response = new Response<CargoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {

			if(cargoDto.getDsCargo() == null) {
				throw new Exception("Campos vazios. ");
			}
			cargoDto = this.cargoService.save(cargoDto);
			response.setData(cargoDto);
			return ResponseEntity.ok(response);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@DeleteMapping("/loja_airsoft/cargo/delete/{id}")
	public @ResponseBody ResponseEntity<Response<CargoDto>> deleteCargo(@PathVariable Integer id) {
		
		Response<CargoDto> response = new Response<CargoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			Boolean retorno = this.cargoService.delete(id);
			
			if(retorno == false || retorno == null) {
				return ResponseEntity.badRequest().body(response);
			}
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
}
