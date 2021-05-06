package teste3;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Cliente3Teste {
	
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
	
	// Fiz apenas o teste deste método, porque os testes dos outros já estão presentes no primeiro exercicio
	
	@Test
	public void criaCliente(){
		
		Cliente3 c1 = Cliente3.criaCliente("Jonatas", 100);
		Cliente3 c2 = Cliente3.criaCliente("Joao", 100);
		Cliente3 c3 = Cliente3.criaCliente("Maicon", 100);
		Cliente3 c4 = Cliente3.criaCliente("Chris", 100);
		Cliente3 c5 = Cliente3.criaCliente("Griezman", 100);
		assertNotNull(c1);
		assertNotNull(c2);
		assertNotNull(c3);
		assertNotNull(c4);
		assertNotNull(c5);
		c5.fimCliente();
		c5 = null;
		assertNull(c5);
		Cliente3 c6 = Cliente3.criaCliente("Samuel", 100);
		assertNotNull(c6);
	}
	
}
