package com.loja_airsoft.app.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loja_airsoft.app.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
	
	private int idUsuario;
	private Date dtNascCliente;
	private String nmUsuario;
	private EnderecoDto endereco;
	private List<DocumentoDto> documento = new ArrayList<DocumentoDto>();
	private List<TelefoneDto> telefone = new ArrayList<TelefoneDto>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<PerfilDto> perfil = new ArrayList<PerfilDto>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<VendaDto> venda = new ArrayList<VendaDto>();;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private CargoDto cargoDto;
	
	public UsuarioDto() {
		
	}
	
	public UsuarioDto(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.dtNascCliente = usuario.getDtNascCliente();
		this.nmUsuario = usuario.getNmUsuario();
		this.endereco = new EnderecoDto(usuario.getEndereco());
		usuario.getDocumento().forEach(documento -> this.documento.add(new DocumentoDto(documento)));
		usuario.getTelefone().forEach(telefone -> this.telefone.add(new TelefoneDto(telefone)));
		usuario.getVenda().forEach(venda -> this.venda.add(new VendaDto(venda)));
		usuario.getPerfil().forEach(perfil -> this.perfil.add(new PerfilDto(perfil)));
	}

}
