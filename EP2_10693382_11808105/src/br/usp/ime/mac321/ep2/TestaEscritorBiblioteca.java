package br.usp.ime.mac321.ep2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestaEscritorBiblioteca {
	
	static ComparaArquivos c;
	static EscritorLivrosDaoImplementacao escritorLivro;
	static EscritorEmprestimosDaoImplementacao escritorEmprestimo;
	static EscritorExemplaresDaoImplementacao escritorExemplar;
	static EscritorUsuariosDaoImplementacao escritorUsuario;
	
	@BeforeAll
	public static void setUp(){
		
		c = new ComparaArquivos();
		escritorLivro = new  EscritorLivrosDaoImplementacao("csv/livrosCopia.csv");
		escritorEmprestimo = new  EscritorEmprestimosDaoImplementacao("csv/emprestimosCopia.csv");
		escritorExemplar = new  EscritorExemplaresDaoImplementacao("csv/exemplaresCopia.csv");
		escritorUsuario = new  EscritorUsuariosDaoImplementacao("csv/usuariosCopia.csv");
	}
	
	@Test
	void testaLivros() {
		escritorLivro.setAllLivros();
		assertTrue(c.compara("csv/livros.csv", "csv/livrosCopia.csv"));
		
	}
	
	@Test
	void testaEmprestimos() {
		escritorEmprestimo.setAllEmprestimos();
		assertTrue(c.compara("csv/emprestimos.csv","csv/emprestimosCopia.csv"));
		
	}
	
	@Test
	void testaExemplares() {
		escritorExemplar.setAllExemplares();
		assertTrue(c.compara("csv/exemplares.csv","csv/exemplaresCopia.csv"));
		
	}
	
	@Test
	void testaUsuarios() {
		escritorUsuario.setAllUsuarios();
		assertTrue(c.compara("csv/usuarios.csv","csv/usuariosCopia.csv"));
		
	}

}
