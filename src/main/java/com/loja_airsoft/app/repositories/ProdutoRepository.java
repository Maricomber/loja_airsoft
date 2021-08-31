package com.loja_airsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.Produto;

@Transactional(readOnly = true)
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Produto findByIdProduto(Integer prd_id_produto);
}
