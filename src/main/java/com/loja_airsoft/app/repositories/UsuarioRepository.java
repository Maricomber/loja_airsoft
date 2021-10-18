package com.loja_airsoft.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loja_airsoft.app.entities.Perfil;
import com.loja_airsoft.app.entities.Usuario;


@Transactional(readOnly = true)
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByIdUsuario(Integer id_usuario);
	List<Usuario> findByPerfil(Perfil perfil);
}
