package com.loja_airsoft.app.enums;

public enum CargoEnum {

	VENDEDOR(1,"Vendedor"),
	SUPERVISOR(2,"Supervisor"),
	GERENTE(3,"Gerente"),
	ADM(4,"Administrador");
	
	private Integer id;
	private String descricao;
	
	 CargoEnum(Integer id, String descricao){
		 this.id = id;
		 this.descricao = descricao;
	 }
}
