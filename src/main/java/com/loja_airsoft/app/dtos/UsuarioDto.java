package com.loja_airsoft.app.dtos;

import java.util.Date;
import java.util.List;

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
	private List<DocumentoDto> documento;
	private List<TelefoneDto> telefone;
	private List<VendaDto> venda;
	private List<PerfilDto> perfil;
	
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
