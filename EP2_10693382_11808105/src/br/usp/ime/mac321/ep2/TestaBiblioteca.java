package br.usp.ime.mac321.ep2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestaBiblioteca {
	
	static Biblioteca biblioteca;
	static List<Exemplar> exemplaresDisponiveis;
	static List<Exemplar> exemplaresExtraviados;
	static List<Exemplar> exemplaresExistentes;
	static List<Livro> livrosDoAutor;
	static LeitorBibliotecaDAO leitor;
	

	@BeforeAll
	public static void setUp() {
		
		biblioteca = new Biblioteca();
		exemplaresDisponiveis = new ArrayList<Exemplar>();
		livrosDoAutor = new ArrayList<Livro>();
		exemplaresExtraviados = new ArrayList<Exemplar>();
		leitor = new LeitorBibliotecaDaoImplementacao();
		exemplaresExistentes = new ArrayList<Exemplar>();
		
	}
	

	@Test
	void buscaExemplaresDisponiveis() {
		
		exemplaresDisponiveis = biblioteca.buscaExemplaresDisponiveis("“1984”","07/07/21");
		assertEquals(1,exemplaresDisponiveis.size());
		assertEquals("E006",exemplaresDisponiveis.get(0).getIdExemplar());
		assertEquals("2468Z",exemplaresDisponiveis.get(0).getIdLivro());
		
		assertEquals(null, biblioteca.buscaExemplaresDisponiveis("nao existe","07/07/21")); 
	}
	
	@Test
	void buscaLivrosPeloAutor() {
		
		livrosDoAutor = biblioteca.buscaLivrosPeloAutor("Ana Mello");
		assertEquals(1,livrosDoAutor.size());
		assertEquals("Lógica para Computação",livrosDoAutor.get(0).getTitulo());
		
		livrosDoAutor = biblioteca.buscaLivrosPeloAutor("Marcelo Finger");
		assertEquals(2,livrosDoAutor.size());
		assertEquals("Lógica para Computação",livrosDoAutor.get(0).getTitulo());
		assertEquals("A volta dos que não foram",livrosDoAutor.get(1).getTitulo());
		
		livrosDoAutor = biblioteca.buscaLivrosPeloAutor("nao existe");
		assertTrue(livrosDoAutor.isEmpty());
	}
	
	@Test
	void listarExemplaresExtraviados() {
		
		exemplaresExtraviados = biblioteca.listarExemplaresExtraviados("1234X","07/08/21");
		assertTrue(exemplaresExtraviados.isEmpty());
		/*
		exemplaresExistentes = leitor.getAllExemplares("csv/exemplares.csv");

		exemplaresExistentes.get(0).emprestimo("123456789-00", "06/07/21");
		assertEquals("extraviado", exemplaresExistentes.get(0).getEstado("07/08/21"));
		
		exemplaresExtraviados = biblioteca.listarExemplaresExtraviados(exemplaresExistentes.get(0).getIdLivro(),"07/08/21");
		assertEquals(1,exemplaresExtraviados.size());
		assertEquals("extraviado",exemplaresExtraviados.get(0).getEstado("07/08/21"));
		*/
	}


}
