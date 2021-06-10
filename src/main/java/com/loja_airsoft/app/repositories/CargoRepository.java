package com.loja_airsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.Cargo;

@Transactional(readOnly = true)
@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

	Cargo findByIdCargo(Integer id_cargo);
}
