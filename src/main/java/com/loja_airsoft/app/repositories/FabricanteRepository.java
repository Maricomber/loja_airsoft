package com.loja_airsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.Fabricante;

@Transactional(readOnly = true)
@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer>{

	Fabricante findByIdFabricante(Integer id_fabricante);
}
