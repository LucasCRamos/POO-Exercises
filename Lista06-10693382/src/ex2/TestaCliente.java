package ex2;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestaCliente{
	
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

	
	Cliente c1 = new Cliente("Lucas",1000);
	
	@Test
	void testeSemExceção() {
		try {
			c1.saque(10);
			c1.deposito(20);
		}
		
		catch (NegativeException e) {
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
				NegativeException.class,
				() -> {c1.saque(1001);}
		);
	}
	
	@Test
	void testaDeposito() {
		
		assertThrows(
				NegativeException.class,
				() -> {c1.deposito(-20);}
		);
	}
		
}
