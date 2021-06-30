package br.com.springboot.curso_jdev_treinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.curso_jdev_treinamento.model.Usuario;
import br.com.springboot.curso_jdev_treinamento.repository.UsuarioRepository;

@RestController
public class GreetingsController {
	
	@Autowired //ic cd cdi noss  injeção de dependencias
	private UsuarioRepository usuarioRepository;
 
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String name) {
		return "Curso  Spring Boot API: " + name + "!";
	}
	
	@RequestMapping(value = "/olamundo/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String retornaOlaMundo(@PathVariable String nome) {
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuarioRepository.save(usuario); //grava no banco de dados
		
		return "Olá mundo: " + nome;
	}

	@GetMapping(value = "/listatodos")
	@ResponseBody //Retorna os dados para o corpo dá resposta
	public ResponseEntity<List<Usuario>> listaUsuario() {
		//retorna a lista de usuarios
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		//ok deu tudo certo , vai retorna a lista em json ,ResponseEntity vai consulta o banco e retorna os dds
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
}