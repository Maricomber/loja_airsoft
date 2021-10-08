package com.loja_airsoft.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loja_airsoft.app.dtos.UsuarioDto;
import com.loja_airsoft.app.services.UsuarioService;

@Controller
@RequestMapping(path = {"/funcionarios"})
public class FuncionarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public String funcionarios(ModelMap model) {
        
		try {
			List<UsuarioDto>usuariosDto = this.usuarioService.findUsuarios();
			
			if(usuariosDto.equals(null)) {
				throw new Exception("Usuario não encontrado");
			}
			model.addAttribute("funcionarios", usuariosDto);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "funcionarios";
		
	}
}