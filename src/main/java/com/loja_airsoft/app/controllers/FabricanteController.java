package com.loja_airsoft.app.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loja_airsoft.app.dtos.UsuarioDto;
import com.loja_airsoft.app.services.UsuarioService;

@Controller
@RequestMapping(path = {"/fabricantes"})
public class FabricanteController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public String fabricantes(ModelMap model) {
        
		try {
			List<UsuarioDto>usuariosDto = this.usuarioService.findUsuarios();
			
			if(usuariosDto.equals(null)) {
				throw new Exception("Usuario não encontrado");
			}
			model.addAttribute("fabricantes", usuariosDto);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "fabricantes";
		
	}
}
