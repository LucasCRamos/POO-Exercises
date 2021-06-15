package ex3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestaCliente2{
	
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

	
	Cliente2 c1 = new Cliente2("Lucas",1000);
	
	@Test
	void testeSemExceção() {
		try {
			c1.saque(10);
			c1.deposito(20);
		}
		
		catch (NegativeException2 e) {
			System.out.println("Deu erro!");
			fail();
		}
		finally {
			if(c1.getSaldo() < 0) {
				c1.setSaldo(0);
			}
		}
	}
	
	@Test
	void testaSaque() {
		
		assertThrows(
				NegativeException2.class,
				() -> {c1.saque(1001);}
		);
	}
	
	@Test
	void testaDeposito() {
		
		assertThrows(
				NegativeException2.class,
				() -> {c1.deposito(-20);}
		);
	}
	
	@Test
	void testaDiferenca(){
		
		try {
			
			c1.saque(-10);
			
		}
		
		catch(NegativeException2 e) {
			
			assertEquals("ex3.NegativeException2: Saque inválido, valor negativo: -10.0", e.toString());
		}
		
		try {
			
			c1.saque(20000);
			
		}
		
		catch(NegativeException2 e) {
			
			assertEquals("ex3.NegativeException2: Saque inválido, valor maior do que o saldo: 20000.0", e.toString());
		}
		
		
		try {
			
			c1.deposito(-20);
			
		}
		
		catch(NegativeException2 e) {
			
			assertEquals("ex3.NegativeException2: Depósito inválido, valor negativo: -20.0",e.toString());
		}
	}
		
}
