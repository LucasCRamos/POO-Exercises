package br.usp.ime.mac321.ep2;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	public String realizaEmprestimo(String data, String cpf, String nomeLivro){
		return "x";
	}
	
	public List<Exemplar> buscaExemplaresDisponiveis(String nomeLivro, String data){
		String idLivro = "";
		LeitorBibliotecaDAO leitor = new LeitorBibliotecaDaoImplementacao();
		List<Livro> livros = new ArrayList<Livro>();
		List<Exemplar> exemplaresDisponiveis = null;
		List<Exemplar> exemplaresExistentes = new ArrayList<Exemplar>();
		
		livros = leitor.getAllLivros("csv/livros.csv");
		
		for(Livro l : livros) {
			if ((l.getTitulo()).equals(nomeLivro)){
				idLivro = l.getIdLivro();
			}
		}
		
		if (!idLivro.equals("")) {
			
			exemplaresDisponiveis = new ArrayList<Exemplar>();
			
			exemplaresExistentes = leitor.getAllExemplares("csv/exemplares.csv");
			
			for(Exemplar e : exemplaresExistentes) {

				if ((e.getIdLivro()).equals(idLivro) && (e.getEstado(data)).equals("disponivel")){
					exemplaresDisponiveis.add(e);

				}
			}
		}
		
		return exemplaresDisponiveis;
	}
		
	public List<Livro> buscaLivrosPeloAutor(String nomeAutor){
		
		LeitorBibliotecaDAO leitor = new LeitorBibliotecaDaoImplementacao();
		List<Livro> livrosExistentes = new ArrayList<Livro>();
		List<Livro> livrosDoAutor = new ArrayList<Livro>();
		
		livrosExistentes = leitor.getAllLivros("csv/livros2.csv");
		
		for(Livro l : livrosExistentes) {
			for(String s : l.getAutores()) {
				if(s.equals(nomeAutor))
					livrosDoAutor.add(l);
			}
			
		}
		
		return livrosDoAutor;
		
	}
	
	public List<Exemplar> listarExemplaresExtraviados(String idLivro, String data){
		
		LeitorBibliotecaDAO leitor = new LeitorBibliotecaDaoImplementacao();
	
		List<Exemplar> exemplaresExtraviados = null;
		List<Exemplar> exemplaresExistentes = new ArrayList<Exemplar>();
		
		exemplaresExtraviados = new ArrayList<Exemplar>();
		
		exemplaresExistentes = leitor.getAllExemplares("csv/exemplares.csv");
		
		for(Exemplar e : exemplaresExistentes) {

			if ((e.getIdLivro()).equals(idLivro) && (e.getEstado(data)).equals("extraviado")){
				exemplaresExtraviados.add(e);
			}
		}
	
		return exemplaresExtraviados;
	}

}
