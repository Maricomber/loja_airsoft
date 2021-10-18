package com.loja_airsoft.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.loja_airsoft.app.dtos.PerfilDto;
import com.loja_airsoft.app.dtos.TelefoneDto;
import com.loja_airsoft.app.dtos.UsuarioDto;
import com.loja_airsoft.app.enums.PerfilEnum;
import com.loja_airsoft.app.response.Response;
import com.loja_airsoft.app.services.PerfilService;
import com.loja_airsoft.app.services.UsuarioService;

@Controller
@RequestMapping(path = {"/fabricantes"})
public class FabricanteController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PerfilService perfilService;
	
	@GetMapping
	public String fabricantes(ModelMap model) {
		TelefoneDto telefoneDto = new TelefoneDto();
		telefoneDto.setIdTelefone(1);
		
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.getTelefone().add(telefoneDto);
        
		try {
			List<UsuarioDto>usuariosDto = this.usuarioService.findUsuarios();
			
			if(usuariosDto.equals(null)) {
				throw new Exception("Usuario não encontrado");
			}
			model.addAttribute("fabricantes", usuariosDto);
			model.addAttribute("usuarioDto", usuarioDto);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "fabricantes";
		
	}
	
	@PostMapping
	public String savePerfil(@ModelAttribute UsuarioDto usuarioDto, ModelMap model) {

		Response<UsuarioDto> response = new Response<UsuarioDto>();
		List<String>erros = new ArrayList<String>();
		List<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();
		List<PerfilDto> perfil = new ArrayList<PerfilDto>();
		try {

			if(usuarioDto.getNmUsuario() == null) {
				throw new Exception("Campos vazios. ");
			}
			perfil.add(this.perfilService.findById(PerfilEnum.FORNECEDOR.getIdPerfil()));
			usuarioDto.setPerfil(perfil);
			usuarioDto = this.usuarioService.save(usuarioDto);
			
			
		}catch (Exception e) {

		}
		return fabricantes(model);
	}
	
}
