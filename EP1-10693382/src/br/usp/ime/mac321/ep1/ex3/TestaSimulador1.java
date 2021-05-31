package br.usp.ime.mac321.ep1.ex3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestaSimulador1 { 

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
	public void verificaImprime() {
		
		Simulador1.main(null);
		
		assertEquals("Simulação Iniciada\n0 min\nMédico Criado\nPaciente Criado\nMédico consulta temperatura: 36.5\nMédico consulta concentração: 110000.0\n"
				+ "5 min\nPaciente inicia surto infeccioso\n"
				+ "10 min\nMédico consulta temperatura: 41.5\nMédico consulta concentração: 110000.0\n"
				+ "20 min\nMédico consulta temperatura: 41.5\nMédico consulta concentração: 110000.0\n"
				+ "30 min\nMédico consulta temperatura: 41.5\nMédico consulta concentração: 110000.0\n"
				+ "40 min\nMédico consulta temperatura: 41.5\nMédico consulta concentração: 110000.0\n"
				+ "50 min\nMédico consulta temperatura: 41.5\nMédico consulta concentração: 110000.0\n"
				+ "60 min\nMédico consulta temperatura: 41.5\nMédico consulta concentração: 110000.0\n"
				+ "70 min\nMédico verifica óbito do paciente\nSimulação terminada\n", outContent.toString());
		
		

	}
}
