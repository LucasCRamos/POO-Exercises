package br.usp.ime.mac321.ep1.ex2;

import static org.junit.Assert.assertEquals;

import org.junit.*;


public class TestaDMP {
	
	Medico medico;
	Paciente paciente;
	Droga droga;

	
	@Before
	public void setUp() {
		
		medico = new Medico(5,"CKK");
		paciente = new Paciente(36,100000,5,5,0);
		droga = new Droga(27*Math.pow(10, -3),54*Math.pow(10, -3));
	}
	
	//TESTES DO MÉDICO
	
	@Test
	
	public void testaGetFreq() {
		
		assertEquals(5,medico.getFreq());
	}
	
	@Test
	public void testaDecideDroga() {
		
		assertEquals("CKK",medico.decideDroga());
		

	}
	
	@Test
	public void testaDecideDuracaoDroga() {
		
		assertEquals(0,medico.decideDuracaoDroga());
		

	}
	
	//TESTES DO PACIENTE
	
	@Test
	
	public void testaGets() {
		
		assertEquals(36,paciente.getTemperatura(),0.000001);
		assertEquals(100000,paciente.getConcentracaoPAC(),0.000001);
		assertEquals(5,paciente.getAumentoTemperatura(),0.000001);
		assertEquals(5,paciente.getFrequenciaSurtos());
		assertEquals(0,paciente.getVelocidadeAumentoPAC(),0.000001);
	}
	
	@Test
	public void testaValorTemperatura() {
		
		assertEquals(41, paciente.valorTemperatura(10),0.000001);
	}
	
	@Test
	public void testaValorConcentracao() {
		
		assertEquals(100000, paciente.valorConcentracao(10),0.000001);
	}
	
	@Test
	public void testaEstaVivo() {
		
		assertEquals(true, paciente.estaVivo(30));
		assertEquals(false, paciente.estaVivo(70));

	}
	
	//TESTES DA DROGA
	
	@Test
	public void testaGetVelRedTemp() {
		
		assertEquals(0.027,droga.getVelRedTemp(),0.000001);
		

	}
	
	@Test
	public void testaGetVelRedConc() {
		
		assertEquals(0.054,droga.getVelRedConc(),0.000001);
		

	}
	
	
	
}

