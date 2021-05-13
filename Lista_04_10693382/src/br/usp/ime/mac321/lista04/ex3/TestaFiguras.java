package br.usp.ime.mac321.lista04.ex3;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestaFiguras {
	
	Retangulo ret;
	Quadrado quad;
	Circulo circ;
	
	@Before
	public void setUp() {
		
		ret = new Retangulo(2,10);
		quad = new Quadrado(5);
		circ = new Circulo(10);
	}
	
	// INICIO TESTES CIRCULO
	
	@Test
	public void areaCirculo() {
		
		assertEquals(314.1592653, circ.calculaArea(),0.0001);
	}
	
	@Test
	public void perimetroCirculo() {
		assertEquals(62.83185, circ.calculaPerimetro(),0.0001);
	}
	
	@Test
	public void corCirculo() {
		assertEquals("Azul", circ.pegaCor());
	}
	
	@Test
	public void mudaCorCirculo() {
		circ.mudaCor("Verde");
		assertEquals("Verde", circ.pegaCor());
	}
	
	
	
	// INICIO TESTES RETANGULO
	
	@Test
	public void areaRetangulo() {
		
		assertEquals(20,ret.calculaArea(),0.0001);
	}
	
	@Test
	public void perimetroRetangulo() {
		assertEquals(24, ret.calculaPerimetro(),0.0001);
	}
	
	@Test
	public void corRetangulo() {
		assertEquals("Azul", ret.pegaCor());
	}
	
	@Test
	public void mudaCorRetangulo() {
		ret.mudaCor("Vermelho");
		assertEquals("Vermelho", ret.pegaCor());
	}
	
	
	
	// INICIO TESTES QUADRADO
	
	@Test
	public void areaQuadrado() {
		
		assertEquals(25,quad.calculaArea(),0.0001);
	}
	
	@Test
	public void perimetroQuadrado() {
		assertEquals(20, quad.calculaPerimetro(),0.0001);
	}
	
	@Test
	public void corQuadrado() {
		assertEquals("Azul", quad.pegaCor());
	}
	
	@Test
	public void mudaCorQuadrado() {
		quad.mudaCor("Rosa");
		assertEquals("Rosa", quad.pegaCor());
	}
	

}
