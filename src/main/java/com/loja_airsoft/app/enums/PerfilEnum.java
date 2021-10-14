package com.loja_airsoft.app.enums;

public enum PerfilEnum {
	CLIENTE(1, "Cliente"),
	FUNCIONARIO(2, "Funcionário"),
	FORNECEDOR(3, "Fornecedor");
	
	private Integer idPerfilEnum;
	private String dsPerfilEnum;
	
	PerfilEnum(int idPerfilEnum, String dsPerfilEnum) {
		this.idPerfilEnum = idPerfilEnum;
		this.dsPerfilEnum = dsPerfilEnum;
	}
	
	public Integer getIdPerfil() {
		return this.idPerfilEnum;
	}
	public String getDescricao() {
		return this.dsPerfilEnum;
	}

}
