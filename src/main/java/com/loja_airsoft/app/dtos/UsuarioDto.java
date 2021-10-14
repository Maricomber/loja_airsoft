package com.loja_airsoft.app.dtos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	private String dtNascCliente;
	private String nmUsuario;
	private EnderecoDto endereco;
	private List<DocumentoDto> documento = new ArrayList<DocumentoDto>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<TelefoneDto> telefone = new ArrayList<TelefoneDto>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<PerfilDto> perfil = new ArrayList<PerfilDto>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<VendaDto> vendedor = new ArrayList<VendaDto>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<VendaDto> cliente = new ArrayList<VendaDto>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private CargoDto cargo;
	
	public UsuarioDto() {
		
	}
	
	public UsuarioDto(Usuario usuario) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		this.idUsuario = usuario.getIdUsuario();
		this.dtNascCliente = dateFormat.format(usuario.getDtNascCliente());
		this.nmUsuario = usuario.getNmUsuario();
		this.endereco = new EnderecoDto(usuario.getEndereco());
		if(!(usuario.getCargo() == null)) {
			this.cargo = new CargoDto(usuario.getCargo());
		}
		usuario.getDocumento().forEach(documento -> this.documento.add(new DocumentoDto(documento)));
		usuario.getTelefone().forEach(telefone -> this.telefone.add(new TelefoneDto(telefone)));
//		usuario.getCliente().forEach(venda -> this.cliente.add(new VendaDto(venda)));
//		usuario.getVendedor().forEach(venda -> this.vendedor.add(new VendaDto(venda)));
		usuario.getPerfil().forEach(perfil -> this.perfil.add(new PerfilDto(perfil)));
	}

}
