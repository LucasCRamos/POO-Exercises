package teste2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Cliente2Teste {
	
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
		
		Cliente2 c1 = new Cliente2("Ragnar", 8931);
		
		c1.imprime();
		
		assertEquals("numero: 1002\ntitular: Ragnar\nsaldo: 8931.0", outContent.toString());
	
	}
	
	@Test
	public void testaNome() {
		
		Cliente2 c2 = new Cliente2("Lucas");
		
		boolean result = c2.verificaNome("Lucas");
		
		assertEquals(true,result);

	}
	
	@Test	
	public void testaSaldo() {
		
		Cliente2 c3 = new Cliente2("Joana", 3000);
		
		boolean result = c3.verificaSaldo(3000);
		
		assertEquals(true,result);
	
	}
	
	@Test	
	public void testaDeposito() {
		
		Cliente2 c4 = new Cliente2("Maria", 2000);
			
		c4.deposito(-50);
	
		assertEquals("0", outContent.toString());
	
	}
	
	
	@Test	
	public void testaSaque() {
		
		Cliente2 c5 = new Cliente2("Fernanda", 100);
		
		c5.saque(110);
		
		assertEquals("0", outContent.toString());
		
		assertEquals(true,c5.getBloqueado());
		
		Cliente2 c6 = new Cliente2("Abel", 100);
		
		Cliente2 c7 = new Cliente2("Bruno", 100);
		
		Cliente2 c8 = new Cliente2("Carlos", 100);
		
		Cliente2 c9 = new Cliente2("Douglas", 100);
		
		Cliente2 c10 = new Cliente2("Estefany", 100);
		
		c6.saque(200);
		
		c7.saque(200);
		
		c8.saque(200);
		
		c9.saque(200);
		
		c10.saque(200);
		
		//bloqueados: c5,c6,c7,c8,c9,c10
		
		assertEquals(6,c10.getNumBloq());
	
	}
	
}
