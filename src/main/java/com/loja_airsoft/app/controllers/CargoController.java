package com.loja_airsoft.app.controllers;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
			if(cargoDto.getIdCargo() == null && cargoDto.getDsCargo().equals("")) {
				cargos = cargoService.findCargos();
				model.put("cargos", cargos);
				throw new Exception("Cargo não encontrado");
			}
			cargos = cargoService.findByCargo(cargoDto);
			model.put("cargos", cargos);
			return "cargos";
		}catch (Exception e) {
			 return null;
		}
		
	}
	
	@PostMapping(path = {"/save"})
	public String saveCargo(@ModelAttribute CargoDto cargoDto, ModelMap model) {
		List<CargoDto>cargos;
		try {
			cargoDto = this.cargoService.save(cargoDto);
			cargos = this.cargoService.findCargos();
			
			model.put("cargos", cargos);
			model.put("cargoDto",new CargoDto());
			
		}catch (Exception e) {
			 
		}
		return "cargos";
		
	}

	@RequestMapping("/delete")
	public @ResponseBody ResponseEntity<Response<CargoDto>>  delete(CargoDto cargoDto, ModelMap model) {
		List<CargoDto>cargos;
		Response<CargoDto> response = new Response<CargoDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(!this.cargoService.delete(cargoDto)) {
				throw new Exception();
			}
			cargos = this.cargoService.findCargos();
			model.put("cargos", cargos);

		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
}
