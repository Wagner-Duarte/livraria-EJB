package br.com.livraria.webservices;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import br.com.livraria.modelo.Livro;

@Stateless
@WebService
public class LivrariaWS {
	
	public List<Livro> getLivrosPeloNoome(String nome){
		
		System.out.println("teste LivrariaWS" + nome);
		return null;
	}

}
