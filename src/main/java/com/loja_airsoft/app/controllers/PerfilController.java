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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loja_airsoft.app.dtos.PerfilDto;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.PerfilService;

@Controller
@RequestMapping(path = {"/perfis"})
public class PerfilController {

	@Autowired
	PerfilService perfilService;
	
	@GetMapping
	public String perfis(ModelMap model) {
		
		try {
			List<PerfilDto>perfilsDto = this.perfilService.findPerfils();
			
			if(perfilsDto.equals(null)) {
				throw new Exception("Perfil não encontrado");
			}
			model.addAttribute("perfis", perfilsDto);
			model.addAttribute("perfilDto", new PerfilDto());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "perfis";
		
	}
	
	@PostMapping
	public String perfilByPerfil(@ModelAttribute PerfilDto perfilDto, ModelMap model) {
		List<PerfilDto>perfis;
		try {
			if(perfilDto.getIdPerfil() == null && perfilDto.getDsPerfil().equals("")) {
				perfis = this.perfilService.findPerfils();
				model.put("perfis", perfis);
			}
			
			perfis = this.perfilService.findByPerfil(perfilDto);
			model.put("perfis", perfis);
	
		}catch (Exception e) {
			 
		}
		return "perfis";
		
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Response<PerfilDto>> update(@RequestBody PerfilDto perfilDto){
		
		List<String>erros = new ArrayList<String>();
		Response<PerfilDto>response = new Response<PerfilDto>();
		
		try {
			perfilDto = this.perfilService.save(perfilDto);
			if(perfilDto.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(perfilDto);
		return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}

	}
	
//	@GetMapping
//	public @ResponseBody ResponseEntity<Response<List<PerfilDto>>> findPerfils(HttpServletRequest request) {
//		
//		Response<List<PerfilDto>> response = new Response<List<PerfilDto>>();
//		List<String>erros = new ArrayList<String>();
//		
//		try{
//			List<PerfilDto>perfilsDto = this.perfilService.findPerfils();
//			
//			if(perfilsDto.equals(null)) {
//				throw new Exception("Perfil não encontrado");
//			}
//			response.setData(perfilsDto);
//			return ResponseEntity.ok(response);
//		}catch (Exception e) {
//			erros.add(e.getMessage());
//			response.setErrors(erros);
//			return ResponseEntity.badRequest().body(response);
//		}
//		
//	}
	@PostMapping(path = {"/save"})
	public @ResponseBody ResponseEntity<Response<PerfilDto>> savePerfil(@RequestBody PerfilDto perfilDto) {
		
		Response<PerfilDto> response = new Response<PerfilDto>();
		List<String>erros = new ArrayList<String>();
		
		try {

			if(perfilDto == null) {
				throw new Exception("Campos vazios. ");
			}
			perfilDto = this.perfilService.save(perfilDto);
			response.setData(perfilDto);
			return ResponseEntity.ok(response);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Response<PerfilDto>> deletePerfil(@PathVariable Integer id) {
		
		Response<PerfilDto> response = new Response<PerfilDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			this.perfilService.delete(id);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
}