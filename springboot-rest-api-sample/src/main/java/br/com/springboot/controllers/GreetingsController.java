package br.com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping(value = "atualizar") //mapeia a url
	@ResponseBody //descrição  da resposta
	public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) { //recebe os dados para salvar
		//qnd tem ? pode retorna qlq coisa string como mensagem e objeto no retorno
		if (usuario.getId() == null) {
			
			return new ResponseEntity<String>("Id não foi informado para atualização.", HttpStatus.OK);
		}
		
		//ele vai atualizar roda diretamente no banco retorna estado persistente pra gente de um usuario
		Usuario user = usuarioRepository.saveAndFlush(usuario); //pode retorna esse usuario salvo user
		
		//retorna new com o response passando o user salvo e created pq vai criar o usuarioq
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "delete") //mapeia a url
	@ResponseBody //descrição  da resposta
	public ResponseEntity<String> delete(@RequestParam Long iduser) { //codigo usuario recebe por parametro
		
    		
		//qnd deleta n instacia pra outro atributo pq n tem retorno
		usuarioRepository.deleteById(iduser); // deleta pelo id long
		
		//retorna new com o response passando o user salvo e created pq vai criar o usuarioq
		return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
     
     }
	
	@GetMapping(value = "buscaruserid") //mapeia a url
	@ResponseBody //descrição  da resposta
	public ResponseEntity<Usuario> buscaruserid(@RequestParam(name =  "iduser") Long iduser) { //recebe os dados para consultar
		
		Usuario usuario = usuarioRepository.findById(iduser).get(); //  
		
		//retorna new com o response passando o user salvo e created pq vai criar o usuarioq
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
	
		
	@GetMapping(value = "buscarPorNome") //mapeia a url
	@ResponseBody //descrição  da resposta //aceita duas anotações body e param
	public ResponseEntity<List<Usuario>>buscarPorNome(@RequestParam(name =  "name") String name) { //recebe os dados para consultar
		
		//toUpperCase busca maiusculo tb
		List<Usuario> usuario = usuarioRepository.buscarPorNome(name.trim().toUpperCase()); // pesquisa no banco .trim tira o espaço
		
		//retorna pra tela lista de usuario pq pode retorna mais de um
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	}
}
//testando jar no projeto
//C:\Users\DarkJohn\git\springrestcrud\springboot-rest-api-sample>mvn clean package
// <maven.test.skip>true</maven.test.skip></properties>
//C:\Users\DarkJohn\git\springrestcrud\springboot-rest-api-sample\target>java -jar springboot-rest-api-sample-1.0.0-SNAPSHOT.jar