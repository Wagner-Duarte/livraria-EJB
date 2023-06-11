package br.com.livraria.dao;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.livraria.interceptador.LogInterceptador;
import br.com.livraria.modelo.Usuario;
/**
 * 
 * @author Wagner.Pinto
 *
 */
@Stateless
@Interceptors({LogInterceptador.class})
public class UsuarioDao {
	@PersistenceContext
	private EntityManager manager;

//	public Usuario buscaPeloLogin(String login) {
//		return manager.find(Usuario.class, login);
//	}
	public Usuario buscaPeloLogin(String login) {

		Usuario usuario = (Usuario) this.manager.createQuery("select u from Usuario u where u.login=:pLogin")
				.setParameter("pLogin", login).getSingleResult();
		return usuario;
	}
	
}
