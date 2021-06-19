package com.loja_airsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.Endereco;

@Transactional(readOnly = true)
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

	Endereco findByidEndereco(Integer id_endereco);
}
