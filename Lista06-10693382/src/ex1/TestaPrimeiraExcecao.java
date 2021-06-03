package ex1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestaPrimeiraExcecao {
	

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
	public void TestaGeraPau() {
		
		try {
			
			PrimeiraExcecao.geraPau();
		}
		
		catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Ocorreu erro!");
			
		}
	}

	@Test
	public void TestaPegaPau() {
					
		PrimeiraExcecao.pegaPau();

		assertEquals("Peguei\n",errContent.toString());
	}
	
}
