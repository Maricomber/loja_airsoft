package com.loja_airsoft.app.enums;

public enum TipoDocumentoEnum {

	RG(1, "Cliente"),
	CPF(2, "Funcionário"),
	CNPJ(3, "CNPJ");
	
	private int idTipoDocumentoEnum;
	private String dsTipoDocumentoEnum;
	
	TipoDocumentoEnum(int idTipoDocumentoEnum, String dsTipoDocumentoEnum) {
		this.idTipoDocumentoEnum = idTipoDocumentoEnum;
		this.dsTipoDocumentoEnum = dsTipoDocumentoEnum;
	}
	
	public Integer getId() {
		return this.idTipoDocumentoEnum;
	}
	public String getDescricao() {
		return this.dsTipoDocumentoEnum;
	}
}
