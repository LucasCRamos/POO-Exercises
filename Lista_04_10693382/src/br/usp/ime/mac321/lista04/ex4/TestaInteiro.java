package br.usp.ime.mac321.lista04.ex4;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestaInteiro {
	
	Inteiro i;
	
	@Before
	public void setUp() {
		
		i = new Inteiro(5);
	}
	
	@Test
	public void testaMeIncremente() {
		
		i.meIncremente();
		assertEquals(6,i.getValue());
	}
	
	@Test
	public void testaMeDecremente() {
		i.meDecremente();
		assertEquals(4,i.getValue());
	}
	
	@Test
	public void testaSouNulo() {
		i.meDecremente();
		i.meDecremente();
		i.meDecremente();
		i.meDecremente();
		i.meDecremente();
		assertEquals(true, i.souNulo());
	}
	
	@Test
	public void testaIncrementavel() {
		
		Incrementável i2 = new Inteiro(3);
		i2.meIncremente();
		assertEquals(4,((Inteiro)i2).getValue());
		
		// É necessário fazer o cast, pois o método getValue pertence apenas à classe Inteiro, não estando
		// presente na interface Incrementável.
		
		// Não será possível (sem casting) decrementar a variável do tipo incrementável, pois essa interface não possui o método decremente.
	}
	
	@Test
	public void testaDecrementavel() {
		
		Incrementável i2 = new Inteiro(7);
		((Decrementável)i2).meDecremente();
		assertEquals(6,((Inteiro)i2).getValue());
		
		// Isso foi possível, graças ao casting realizado.
	}
	
}

