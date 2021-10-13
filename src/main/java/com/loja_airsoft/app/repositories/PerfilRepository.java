package com.loja_airsoft.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.Perfil;

@Transactional(readOnly = true)
@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

	Perfil findByIdPerfil(Integer id_Perfil);
	List<Perfil> findByDsPerfilIgnoreCaseContaining(String ds_cargo);
	List<Perfil> findAllByOrderByIdPerfil();
}
