package br.com.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.livraria.interceptador.LogInterceptador;
import br.com.livraria.modelo.Livro;

@Stateless
@Interceptors({LogInterceptador.class})
public class LivroDao {
	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return manager.createQuery("select a from Livro a", Livro.class).getResultList();
	}
	
	public List<Livro> livrosPeloNome(String nome) {

		TypedQuery<Livro> query = this.manager.createQuery("select l from Livro l " + "where l.titulo like :pTitulo",
				Livro.class);
		query.setParameter("pTitulo", "%" + nome + "%");

		return query.getResultList();
	}
	
}
