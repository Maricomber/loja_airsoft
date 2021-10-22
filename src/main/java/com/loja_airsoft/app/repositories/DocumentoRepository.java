package com.loja_airsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.Documento;

@Transactional(readOnly = true)
@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer>  {

	Documento findByIdDocumento(Integer id_documento);
	Documento findByDsDocumento(String ds_documento);
}
