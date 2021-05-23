package br.usp.ime.mac321.ep1.ex2;

import static org.junit.Assert.assertEquals;

import org.junit.*;


public class TestaDMP {
	
	Medico medico;
	Paciente paciente;
	Droga droga;

	
	@Before
	public void setUp() {
		
		medico = new Medico(5);
		paciente = new Paciente(36,100,5,2,3);
		droga = new Droga(20,20);
	}
	
	@Test
	public void testaDecideDroga() {
		

	}
	
	@Test
	public void testaValorTemperatura() {
		
		assertEquals(36, paciente.valorTemperatura(0),0.01);
	}
	
	@Test
	public void testaValorConcentracao() {
		
		assertEquals(100, paciente.valorConcentracao(0),0.01);
	}
	
	@Test
	public void testaEstaVivo() {

	}
	
}

