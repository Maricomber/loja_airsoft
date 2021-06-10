package com.loja_airsoft.app.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.loja_airsoft.app.dtos.CargoDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.CargoService;
import com.loja_airsoft.app.services.impl.CargoServiceImpl;

@Controller
public class CargoController {

	@Autowired
	CargoService cargoService;
	
	@GetMapping(path = {"/{id}"})
	public @ResponseBody ResponseEntity<Response<CargoDto>> findById(@PathVariable int id){
		
		Response<CargoDto>response = new Response<CargoDto>();
		CargoDto cargoDto = new CargoDto();
		
		cargoDto= this.cargoService.findById(id);
		
		if(cargoDto.equals(null)) {
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(cargoDto);
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping(path = {"/{id}"})
	public @ResponseBody ResponseEntity<Response<CargoDto>> update(@PathVariable ("id") int id, 
			@RequestBody CargoDto cargoDto){
		
		Response<CargoDto>response = new Response<CargoDto>();
		CargoDto cargoDtoVerific = new CargoDto();
		
		cargoDtoVerific = this.cargoService.findById(id);
		
		if(cargoDtoVerific.equals(null)) {
			return ResponseEntity.badRequest().body(response);
		}
		else {
			cargoDto = this.cargoService.save(cargoDto);
			if(cargoDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		}
		response.setData(cargoDto);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/findCargos")
	public @ResponseBody ResponseEntity<Response<List<CargoDto>>> findCargos(HttpServletRequest request) {
		
		Response<List<CargoDto>> response = new Response<List<CargoDto>>();
		List<CargoDto>cargosDto = this.cargoService.findCargos();
		
		if(cargosDto.equals(null)) {
			return ResponseEntity.badRequest().body(response);
		}
		request.setAttribute("cargos", cargosDto);
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/savecargo")
	public @ResponseBody ResponseEntity<Response<CargoDto>> saveCargo(CargoDto cargoDto) {
		
		Response<CargoDto> response = new Response<CargoDto>();
		
		if(cargoDto.getDsCargo() != null) {
			cargoDto = this.cargoService.save(cargoDto);
			
			if(cargoDto == null) {
				return ResponseEntity.badRequest().body(response);
			}
			response.setData(cargoDto);
			return ResponseEntity.ok(response);
		}
		else {
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@DeleteMapping("/deletecargo")
	public @ResponseBody ResponseEntity<Response<CargoDto>> deleteCargo(CargoDto cargoDto) {
		
		Response<CargoDto> response = new Response<CargoDto>();
		
		if(cargoDto.getIdCargo() != null) {
			Boolean retorno = this.cargoService.delete(cargoDto);
	
			if(retorno == false || retorno == null) {
				return ResponseEntity.badRequest().body(response);
			}
			response.setData(cargoDto);
			return ResponseEntity.ok(response);
		}
		else {
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	
}
