package br.com.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.livraria.dao.AutorDao;
import br.com.livraria.dao.LivroDao;
import br.com.livraria.modelo.Autor;
import br.com.livraria.modelo.Livro;

@Model
public class LivroBean {
	
	private Livro livro = new Livro();
	private Integer autorId;
	
	@Inject
	private LivroDao livroDao;
	@Inject
	private AutorDao autorDao;

	public void cadastra() {
		
		Autor autor = this.autorDao.buscaPelaId(this.autorId);
		this.livro.setAutor(autor);
		
		this.livroDao.salva(livro);
		
		this.livro = new Livro();
	}

	public List<Autor> getAutores() {
		return autorDao.todosAutores();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public List<Livro> getLivros() {
		return this.livroDao.todosLivros();
	}
}
