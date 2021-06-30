package br.com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.model.Usuario;

@Repository //anota como repository / se extende de outra interface jpa
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//nosa chave primaria e o tipo dela long  é uma interface
	
//u usuario  u de ellias u.nome da nossa classe Usuario like pesquisar por partes
	//%?1% porque só tem 1 parametro por isso 1 o name / upper maiusculo ou minusculo busca igual
	@Query(value = "select u from Usuario u where upper(trim(u.nome)) like %?1%")
	List<Usuario> buscarPorNome(String name);
}