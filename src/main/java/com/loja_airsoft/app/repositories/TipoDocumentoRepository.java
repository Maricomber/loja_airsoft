package com.loja_airsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.TipoDocumento;

@Transactional(readOnly = true)
@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer>{

	 TipoDocumento findByIdTipoDocumento(Integer id_documento);
}
