package br.com.springboot.curso_jdev_treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Usuario;

@Repository //anota como repository / se extende de outra interface jpa
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//nosa chave primaria e o tipo dela long  é uma interface

}
