package ex3;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestaInteiroAritmetico {
	
	// Crio vários objetos, pois os objetos são modificados a cada teste, então eu não tenho
	// como prever o valor final se os testes forem realizados em uma ordem completamente aleatória.
	
	InteiroAritmetico i,i2,j,j2,k,l;
	
	@Before
	public void setUp() {
		
		i = new InteiroAritmetico(5);
		i2 = new InteiroAritmetico(5);
		j = new InteiroAritmetico(2);
		j2 = new InteiroAritmetico(2);
		k = new InteiroAritmetico(3);
		l = new InteiroAritmetico(3);
	}
	
	@Test
	public void testaSome() {
		
		i.someMeCom(i2); // 5+5 = 10
		assertEquals(10,i.getValue());
	}
	
	@Test
	public void testaSubtraia() {
		i.subtraiaDeMim(i); // i-i = 0
		assertEquals(0,i.getValue());
	}
	
	@Test
	public void testaMultiplique() {
		j.multipliqueMePor(j2); // 2*2 = 4
		assertEquals(4,j.getValue());
	}
	
	@Test
	public void testaDivida() { // j2/j2 = 1
		j2.dividaMePor(j2);
		assertEquals(1,j2.getValue());
	}
	
	@Test
	public void testaEquals() {
		assertEquals(true,k.equals​(l));
	}
	
	@Test
	public void testaToString() {
		assertEquals("O valor do número é: 3",l.toString());
	}

}

