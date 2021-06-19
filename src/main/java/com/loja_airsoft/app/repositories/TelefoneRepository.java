package com.loja_airsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.Telefone;

@Transactional(readOnly = true)
@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer>{

	Telefone findByidTelefone(Integer id_telefone);
}
