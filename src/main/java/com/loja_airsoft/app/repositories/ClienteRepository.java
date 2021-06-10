package com.loja_airsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.Cliente;

@Transactional(readOnly = true)
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	Cliente findByCpfCliente(Integer cli_cpf);
}
