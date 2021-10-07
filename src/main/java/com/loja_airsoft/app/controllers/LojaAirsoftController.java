package com.loja_airsoft.app.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LojaAirsoftController {

	@RequestMapping("/")
	public String index() {
		return "menu";
	}
	
	@RequestMapping("/vendas")
	public String vendas() {
		return "vendas";
	}
	
	@RequestMapping("/produtos")
	public String produtos() {
		return "produtos";
	}
	
	@RequestMapping("/fabricantes")
	public String fabricantes() {
		return "fabricantes";
	}
	
	@RequestMapping("/clientes")
	public String clientes() {
		return "clientes";
	}
	
	@RequestMapping("/funcionarios")
	public String funcionarios() {
		return "funcionarios";
	}
	
	@GetMapping("/images/{urlImagemLocal}")
    @ResponseBody
    public byte[] carregaImagensDinamicas(@PathVariable("urlImagemLocal") String nomeImagem) {

    File imagemArquivo = new File("./src/main/resources/templates/images/" + nomeImagem);

        try {
            return Files.readAllBytes(imagemArquivo.toPath());
        } catch (IOException e) {
            return null;
        }

    }

}