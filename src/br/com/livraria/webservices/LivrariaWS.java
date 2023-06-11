package br.com.livraria.webservices;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.livraria.dao.LivroDao;
import br.com.livraria.modelo.Livro;

@Stateless
@WebService
public class LivrariaWS {
	
	@Inject
	LivroDao dao;
	
	@WebResult(name="autores")
	public List<Livro> getLivrosPeloNoome(@WebParam(name="titulo") String nome){
		
		System.out.println("teste LivrariaWS" + nome);
		return dao.livrosPeloNome(nome);
	}

}
