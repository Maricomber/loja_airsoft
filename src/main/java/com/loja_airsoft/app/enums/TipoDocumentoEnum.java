package com.loja_airsoft.app.enums;

public enum TipoDocumentoEnum {

	CLIENTE(1, "Cliente"),
	FUNCIONARIO(2, "Funcionário"),
	FORNECEDOR(3, "Fornecedor");
	
	private int idTipoDocumentoEnum;
	private String dsTipoDocumentoEnum;
	
	TipoDocumentoEnum(int idTipoDocumentoEnum, String dsTipoDocumentoEnum) {
		this.idTipoDocumentoEnum = idTipoDocumentoEnum;
		this.dsTipoDocumentoEnum = dsTipoDocumentoEnum;
	}
	
	public String getDescricao() {
		return this.dsTipoDocumentoEnum;
	}
}
