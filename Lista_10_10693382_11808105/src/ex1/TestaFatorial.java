package ex1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestaFatorial {

	@Test
	void testaCalculaFatorial() {
		assertEquals(120,Fatorial.calculaFatorial(5));
		assertEquals(1,Fatorial.calculaFatorial(0));
		assertEquals(-1,Fatorial.calculaFatorial(-5));
	}

}
