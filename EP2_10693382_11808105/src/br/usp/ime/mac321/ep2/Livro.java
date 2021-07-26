package br.usp.ime.mac321.ep2;

public class Livro {
	
	private String idLivro;
	private String titulo;
	private String[] autores;
	private String ano;
	private String editora;
	private String edicao;
	private String idioma;
	
	
	
	public Livro(String idLivro, String titulo, String[] autores, String ano, String editora, String edicao, String idioma) {
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.autores = autores;
		this.ano = ano;
		this.editora = editora;
		this.edicao = edicao;
		this.idioma = idioma;
	}
	
	public String getIdLivro() {
		return idLivro;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String[] getAutores() {
		return autores;
	}
	
	public String getAno() {
		return ano;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public String getEdicao() {
		return edicao;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	

}
