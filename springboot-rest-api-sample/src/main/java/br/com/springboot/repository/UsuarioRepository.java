package br.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.model.Usuario;

@Repository //anota como repository / se extende de outra interface jpa
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//nosa chave primaria e o tipo dela long  é uma interface

}