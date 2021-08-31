package com.loja_airsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.Venda;

@Transactional(readOnly = true)
@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
	
	Venda findByidVenda(Integer id_venda);

}
