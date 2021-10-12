package com.loja_airsoft.app.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loja_airsoft.app.dtos.CargoDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.CargoService;


@Controller
@RequestMapping(path = {"/cargos"})
public class CargoController {

	@Autowired
	CargoService cargoService;
	
	@GetMapping
	public String cargos(ModelMap model) {
		
		try {
			List<CargoDto>cargosDto = this.cargoService.findCargos();
			
			if(cargosDto.equals(null)) {
				throw new Exception("Cargo não encontrado");
			}
			model.addAttribute("cargos", cargosDto);
			model.addAttribute("cargoDto",new CargoDto());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "cargos";
		
	}

	@PostMapping
	public String cargosById(@ModelAttribute CargoDto cargoDto, ModelMap model) {
		List<CargoDto>cargos;
		try {
			if(cargoDto.getIdCargo() == null) {
				cargos = cargoService.findCargos();
				model.put("cargos", cargos);
				throw new Exception("Cargo não encontrado");
			}
			cargoDto = cargoService.findById(cargoDto.getIdCargo());
			model.put("cargos", cargoDto);
			
		}catch (Exception e) {
			 
		}
		return "cargos";
		
	}
	
	@PostMapping(path = {"/save"})
	public String saveCargo(@ModelAttribute CargoDto cargoDto, ModelMap model) {
		List<CargoDto>cargos;
		try {
			cargoDto = cargoService.save(cargoDto);
			cargos = cargoService.findCargos();
			
			model.put("cargos", cargos);
			model.put("cargoDto",new CargoDto());
			
		}catch (Exception e) {
			 
		}
		return "cargos";
		
	}
//	@GetMapping
//	public @ResponseBody ResponseEntity<Response<List<CargoDto>>> findCargos(HttpServletRequest request) {
//		
//		Response<List<CargoDto>> response = new Response<List<CargoDto>>();
//		List<String>erros = new ArrayList<String>();
//		
//		try{
//			List<CargoDto>cargosDto = this.cargoService.findCargos();
//			
//			if(cargosDto.equals(null)) {
//				throw new Exception("Cargo não encontrado");
//			}
//			response.setData(cargosDto);
//			return ResponseEntity.ok(response);
//		}catch (Exception e) {
//			erros.add(e.getMessage());
//			response.setErrors(erros);
//			return ResponseEntity.badRequest().body(response);
//		}
//		
//	}
//	
//	@PostMapping
//	public @ResponseBody ResponseEntity<Response<CargoDto>> saveCargo(@RequestBody CargoDto cargoDto) {
//		
//		Response<CargoDto> response = new Response<CargoDto>();
//		List<String>erros = new ArrayList<String>();
//		
//		try {
//
//			if(cargoDto == null) {
//				throw new Exception("Campos vazios. ");
//			}
//			cargoDto = this.cargoService.save(cargoDto);
//			response.setData(cargoDto);
//			return ResponseEntity.ok(response);
//			
//		}catch (Exception e) {
//			erros.add(e.getMessage());
//			response.setErrors(erros);
//			return ResponseEntity.badRequest().body(response);
//		}
//		
//	}
//	
//	@DeleteMapping("/{id}")
//	public @ResponseBody ResponseEntity<Response<CargoDto>> deleteCargo(@PathVariable Integer id) {
//		
//		Response<CargoDto> response = new Response<CargoDto>();
//		List<String>erros = new ArrayList<String>();
//		
//		try {
//			if(id == null) {
//				throw new Exception("Campos em branco. ");
//			}
//			this.cargoService.delete(id);
//		}catch (Exception e) {
//			erros.add(e.getMessage());
//			response.setErrors(erros);
//			return ResponseEntity.badRequest().body(response);
//		}
//		return ResponseEntity.ok(response);
//	}
//	
}
