package com.loja_airsoft.app.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.Funcionario;

@Transactional(readOnly = true)
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, BigInteger>{

	Funcionario findByCpfFunc(BigInteger cpfFunc);
}
