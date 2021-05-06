package teste1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ClienteTeste {
	
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
	
	@Test
	public void testaImprime() {
		
		Cliente c1 = new Cliente("Ragnar", 8931);
		
		c1.imprime();
		
		assertEquals("numero: 1002\ntitular: Ragnar\nsaldo: 8931.0", outContent.toString());
	
	}
	
	@Test
	public void testaNome() {
		
		Cliente c2 = new Cliente("Lucas");
		
		boolean result = c2.verificaNome("Lucas");
		
		assertEquals(true,result);

	}
	
	@Test	
	public void testaSaldo() {
		
		Cliente c3 = new Cliente("Joana", 3000);
		
		boolean result = c3.verificaSaldo(3000);
		
		assertEquals(true,result);
	
	}
	
	@Test	
	public void testaDeposito() {
		
		Cliente c4 = new Cliente("Maria", 2000);
		
		c4.deposito(20);
		
		assertEquals(true,c4.verificaSaldo(2020));
		
		c4.deposito(-50);
	
		assertEquals("Deposito invalido com valor negativo", outContent.toString());
	
	}
	
	
	@Test	
	public void testaSaque() {
		
		Cliente c5 = new Cliente("Fernanda", 100);
		
		c5.saque(50);
		
		assertEquals(true,c5.verificaSaldo(50));
		
		c5.saque(60);
		
		assertEquals("Saldo insuficiente", outContent.toString());
	
	}
	
}
