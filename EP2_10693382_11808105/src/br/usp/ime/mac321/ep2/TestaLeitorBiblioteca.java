package br.usp.ime.mac321.ep2;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestaLeitorBiblioteca {

	List<Usuario> usuarios;
	List<Livro> livros;
	List<Exemplar> exemplares;
	List<Emprestimo> emprestimos;
	static LeitorBibliotecaDAO leitor;
	
	@BeforeAll
	public static void setUp(){
		
		leitor  = new LeitorBibliotecaDaoImplementacao();
	}
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static PrintStream out = System.out;
    private static PrintStream err = System.err;


    @BeforeEach
    public void setUpStreams() {

       System.setOut(new PrintStream(outContent));
       System.setErr(new PrintStream(errContent));

    }

    @AfterEach
    public void cleanUpStreams() {

        String output = outContent.toString();

         System.setOut(out);
         System.setErr(err);
         System.out.print(output);

    }
	
	@Test
	public void testLivros(){
		livros = leitor.getAllLivros("csv/livros.csv");
		assertEquals(3, livros.size());
	}
	
	@Test
	public void testExemplares(){
		exemplares = leitor.getAllExemplares("csv/exemplares.csv");
		assertEquals(6, exemplares.size());
	}
	
	@Test
	public void testUsuarios(){
		usuarios = leitor.getAllUsuarios("csv/usuarios.csv");
		assertEquals(2, usuarios.size());
	}
	
	@BeforeEach
	public void setListaExemplarEUsuario() {
		leitor.getAllExemplares("csv/exemplares.csv");
		leitor.getAllUsuarios("csv/usuarios.csv");
	}
	@Test
	public void testEmprestimos(){
		emprestimos = leitor.getAllEmprestimos("csv/emprestimos.csv");
		assertEquals(3, emprestimos.size());
	}
	
	
	@Test
	public void testLivrosComRepeticao(){
		leitor.getAllLivros("csv/livrosComRepetição.csv");
		assertEquals("Dois livros possuem o mesmo valor do campo de identificação.\n", errContent.toString() );
	}
	
	@BeforeEach
	public void setListaLivros() {
		leitor.getAllLivros("csv/livros.csv");
	}
	@Test
	public void testExemplaresComErro(){
		leitor.getAllExemplares("csv/exemplaresComErro.csv");
		assertEquals("Um exemplar de livro foi lido contendo uma referência a um livro que não existe.\n", errContent.toString() );

	}
	
	@BeforeEach
	public void setListaExemplaresEUsuarios() {
		leitor.getAllExemplares("csv/exemplares.csv");
		leitor.getAllUsuarios("csv/usuarios.csv");
	}
	@Test
	public void testEmprestimosComErro(){
		leitor.getAllEmprestimos("csv/emprestimosComErro.csv");
		assertEquals("Um empréstimo foi feito envolvendo um cliente e um exemplar que não existem.\n", errContent.toString() );
	}
	
}
