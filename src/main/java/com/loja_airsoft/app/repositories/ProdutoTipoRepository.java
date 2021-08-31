package com.loja_airsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.ProdutoTipo;

@Transactional(readOnly = true)
@Repository
public interface ProdutoTipoRepository extends JpaRepository<ProdutoTipo, Integer> {

	ProdutoTipo findByIdProdutoTp(Integer pdt_id_produto_tipo);
}
