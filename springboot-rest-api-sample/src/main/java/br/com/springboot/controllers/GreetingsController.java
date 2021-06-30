package br.com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.model.Usuario;
import br.com.springboot.repository.UsuarioRepository;

@RestController
public class GreetingsController {
	
	@Autowired //ic cd cdi noss  injeção de dependencias
	private UsuarioRepository usuarioRepository;
 
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String name) {
		return "Curso  Spring Boot API: " + name + "!";
	}
	
	@RequestMapping(value = "olamundo/{nome}", method = RequestMethod.GET)
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
	
	@PostMapping(value = "salvar") //mapeia a url
	@ResponseBody //descrição  da resposta
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) { //recebe os dados para salvar
		
		//salvar o usuario save
		Usuario user = usuarioRepository.save(usuario); //pode retorna esse usuario salvo user
		
		//retorna new com o response passando o user salvo e created pq vai criar o usuarioq
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "delete") //mapeia a url
	@ResponseBody //descrição  da resposta
	public ResponseEntity<String> delete(@RequestParam Long iduser) { //recebe os dados para salvar
		
		//qnd deleta n instacia pra outro atributo pq n tem retorno
		usuarioRepository.deleteById(iduser); // deleta pelo id long
		
		//retorna new com o response passando o user salvo e created pq vai criar o usuarioq
		return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
	}
}