package ex4;
import ex3.InteiroAritmetico;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestaInteiroModular {
	
	// Crio vários objetos, pois os objetos são modificados a cada teste, então eu não tenho
	// como prever o valor final se os testes forem realizados em uma ordem completamente aleatória.
	
	InteiroModular i,k,l,m,n;
	InteiroAritmetico j;

	
	@Before
	public void setUp() {
		
		i = new InteiroModular(5,3);
		k = new InteiroModular(7,3);
		l = new InteiroModular(7,3);
		m = new InteiroModular(7,3);
		n = new InteiroModular(3,4);
		
		j = new InteiroAritmetico(7);
	}
	
	@Test
	public void testaSome() {
		
		i.someMeCom(j); // (5+7)%3 = 0
		assertEquals(0,i.getValue());
	}
	
	@Test
	public void testaSubtraia() {
		k.subtraiaDeMim(j); // (7-7)%3 = 0
		assertEquals(0,k.getValue());
	}
	
	@Test
	public void testaMultiplique() {
		l.multipliqueMePor(j); // (7*7)%3 = 1
		assertEquals(1,l.getValue());
	}
	
	@Test
	public void testaDivida() {
		m.dividaMePor(j); // (7/7)%3 = 1
		assertEquals(1,m.getValue());
	}
	
	@Test
	public void testaEquals() {
		assertEquals(true,k.equals​(l));
	}
	
	@Test
	public void testaToString() {
		assertEquals("O valor do número é: 3\nO valor de m é: 4",n.toString());
	}
	
}

