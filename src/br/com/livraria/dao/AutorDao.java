package br.com.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.livraria.interceptador.LogInterceptador;
import br.com.livraria.modelo.Autor;
/**
 * 6
 * @author Wagner Duarte
 * 11 de jun. de 2023
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({LogInterceptador.class})
public class AutorDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostConstruct
	void aposCriacao() {
	    System.out.println("[INFO] AutorDao foi criado.");
	}
	
	public void salva(Autor autor)   {
		
	    System.out.println("[INFO] Salvando o Autor " + autor.getNome());

	    manager.persist(autor);
	
	    System.out.println("[INFO] Salvou o Autor " + autor.getNome());

//	    chamado ao service externo que gera um erro **somente exemplo
	    
//	    throw new RuntimeException("erro ao executar proposital");
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}
	
}
