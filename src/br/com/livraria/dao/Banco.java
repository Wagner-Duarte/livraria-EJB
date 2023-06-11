package br.com.livraria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

import br.com.livraria.interceptador.LogInterceptador;
import br.com.livraria.modelo.Autor;
import br.com.livraria.modelo.Livro;
import br.com.livraria.modelo.Usuario;

@Singleton
@Interceptors({LogInterceptador.class})
public class Banco {
	
	public static List<Livro> livros = new ArrayList<Livro>();
	public static List<Autor> autores = new ArrayList<Autor>();
	public static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private static int chave = 1;
	
	static {
		inicializaBanco();
	}
	
	@PostConstruct
    void aposCriacao() {
        System.out.println("[INFO] O Banco acabou de ser criado.");
    }
	
	public void save(Livro livro) {
		livro.setId(chave++);
		livros.add(livro);
	}
	
	public List<Livro> listaLivros() {
		return livros;
	}
	
	public void save(Autor autor) {
		autor.setId(chave++);
		autores.add(autor);
	}
	
	public List<Autor> listaAutores() {
		return autores;
	}

	public Autor buscaPelaId(Integer autorId) {

		for (Autor autor : autores) {
			if(autor.getId().equals(autorId)) {
				return autor;
			}
		}
		return null;
	}
	
	public Usuario buscaPeloNome(String nome) {
		for (Usuario usuario : usuarios) {
			if(usuario.getLogin().equals(nome)) {
				return usuario;
			}
		}
		
		return null;
	}
	
	private static void inicializaBanco() {
		Autor Oracle = new Autor(chave++, "Oracle");
		Autor Youtube = new Autor(chave++, "Youtube");
		Autor Google = new Autor(chave++, "Google ");
		
		autores.add(Oracle);
		autores.add(Youtube);
		autores.add(Google);
		
		livros.add(new Livro("Java 8 ",Oracle));
		livros.add(new Livro("Lógica de Programação",Youtube));

		livros.add(new Livro("CDI: Integre as dependências",Youtube));
		livros.add(new Livro("JSF e JPA",Youtube));

		livros.add(new Livro("JPA Efficaz",Google));
		livros.add(new Livro("JSF Efficaz",Google));
		
		usuarios.add(new Usuario("admin", "pass"));
	}

}
