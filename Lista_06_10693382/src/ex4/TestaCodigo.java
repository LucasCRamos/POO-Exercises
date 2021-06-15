package ex4;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestaCodigo{
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@BeforeEach	
	public void setUpStreams() {
		
	 System.setOut(new PrintStream(outContent));
	 System.setErr(new PrintStream(errContent));
	 
	}
	
	@AfterEach
	public void cleanUpStreams() {
		
	 System.setOut(null);
	 System.setErr(null);
	 
	}
	
	Codigo codigo = new Codigo();
	
	@Test
	void testaPrimeiroNome() throws Exception{
	
		
		try {
			
			codigo.recebeCodigo("macaco int 1 5");
		}
		
		catch(Excecoes e) {
			
			assertEquals("A primeira palavra é diferente de matriz (ex4.Excecoes)", e.toString());
			
		}
		
	}
	
	@Test
	void testaTipo() throws Exception{
		
		try {
			
			codigo.recebeCodigo("matriz hexadecimal 1 5");
		}
		
		catch(Excecoes e) {
			
			assertEquals("O tipo é diferente do esperado (ex4.Excecoes)", e.toString());
			
		}
	
	}
	
	@Test
	void testaNumLinhas() throws Exception{
		
		try {
			
			codigo.recebeCodigo("matriz double 0 5");
		}
		
		catch(Excecoes e) {
			
			assertEquals("O número de linhas é inválido (ex4.Excecoes)", e.toString());
			
		}
		
	}
	
	@Test
	void testaNumColunas() throws Exception{
		
		try {
			
			codigo.recebeCodigo("matriz double 1 -7");
		}
		
		catch(Excecoes e) {
			
			assertEquals("O número de colunas é inválido (ex4.Excecoes)", e.toString());
			
		}
		
	}

}
	