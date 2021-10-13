package com.loja_airsoft.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@RequestMapping(path = {"/save"})
	public @ResponseBody ResponseEntity<Response<PerfilDto>>  savePerfil(PerfilDto perfilDto, ModelMap model) {

		Response<PerfilDto> response = new Response<PerfilDto>();
		List<String>erros = new ArrayList<String>();
		List<PerfilDto> perfis = new ArrayList<PerfilDto>();
		try {

			if(perfilDto.getDsPerfil() == null) {
				throw new Exception("Campos vazios. ");
			}
			perfilDto = this.perfilService.save(perfilDto);
			perfis = this.perfilService.findPerfils();
			model.put("perfis", perfis);
			model.put("perfilDto", new PerfilDto());
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping("/delete")
	public @ResponseBody ResponseEntity<Response<PerfilDto>> delete(PerfilDto perfilDto, ModelMap model) {
		List<PerfilDto>perfis = new ArrayList<PerfilDto>();
		Response<PerfilDto> response = new Response<PerfilDto>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(!this.perfilService.delete(perfilDto.getIdPerfil())) {
				throw new Exception("Campos em branco. ");
			}
			perfis = this.perfilService.findPerfils();
			model.put("perfis", perfis);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
}