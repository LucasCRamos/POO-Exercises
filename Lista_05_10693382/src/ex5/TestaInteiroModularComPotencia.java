package ex5;
import ex3.InteiroAritmetico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.*;


public class TestaInteiroModularComPotencia {
	
	// Crio vários objetos, pois os objetos são modificados a cada teste, então eu não tenho
	// como prever o valor final se os testes forem realizados em uma ordem completamente aleatória.
	
	InteiroModularComPotencia i,j,k,l,m,n,o,p,q,r,s;
	
	InteiroAritmetico ref,ref2,ref3,ref4,zero;

	@Before
	public void setUp() {
		
		i = new InteiroModularComPotencia(5,3);
		j = new InteiroModularComPotencia(5,3);
		k = new InteiroModularComPotencia(5,3);
		l = new InteiroModularComPotencia(5,3);
		
		m = new InteiroModularComPotencia(5,11);
		n = new InteiroModularComPotencia(5,11);
		
		o = new InteiroModularComPotencia(5,11);
		p = new InteiroModularComPotencia(6,13);
		q = new InteiroModularComPotencia(7,17);
		r = new InteiroModularComPotencia(8,12);
		s = new InteiroModularComPotencia(12,11);
		
		ref = new InteiroAritmetico(5);
	}
	
	@Test
	public void testaSome() {
		
		i.someMeCom(ref); // (5+5)%3 = 1
		assertEquals(1,i.getValue());
	}
	
	@Test
	public void testaSubtraia() {
		j.subtraiaDeMim(ref); // (5-5)%3 = 0
		assertEquals(0,j.getValue());
	}
	
	@Test
	public void testaMultiplique() {
		k.multipliqueMePor(ref);  // (5*5)%3 = 1
		assertEquals(1,k.getValue());
	}
	
	@Test
	public void testaDivida() { // (5/5)%3 = 1
		l.dividaMePor(ref);
		assertEquals(1,l.getValue());
	}
	
	@Test
	public void testaEquals() {
		assertEquals(true,m.equals​(n));
	}
	
	@Test
	public void testaToString() {
		assertEquals("O valor do número é: 5\nO valor de m é: 11",o.toString());
	}
	
	
	@Test
	public void PrimeirotestaElevadoA() { // TEOREMA DE FERMAT: a^(m) ≡ a (mod m)
		assertEquals(5,o.elevadoA(11).getResto()); // valor inicial de o = 5
		assertEquals(6,p.elevadoA(13).getResto());  // valor inicial de p = 6
		assertEquals(7,q.elevadoA(17).getResto());  // valor inicial de q = 7
		
		assertNotEquals(r.getValue(),r.elevadoA(12).getResto()); // 8 != 8^12 (mod 12)
	}
	
	@Test
	public void SegundotestaElevadoA() {
		
	long v[] = new long [12];
	int v2[] = new int [3];
	
	
	for (int i=1; i<=12; i++) {
		
		InteiroModularComPotencia a = new InteiroModularComPotencia(3,13);
		
		v[i-1] = a.elevadoA(i).getResto();
		if (v[i-1] == 3) v2[0]+=1;
		if (v[i-1] == 9) v2[1]+=1;
		if (v[i-1] == 1) v2[2]+=1;	
			
	}
	
		String a1 = String.valueOf(v[0]) + String.valueOf(v[1]) + String.valueOf(v[2]); 
		String a2 = String.valueOf(v[3]) + String.valueOf(v[4]) + String.valueOf(v[5]);
		String a3 = String.valueOf(v[6]) + String.valueOf(v[7]) + String.valueOf(v[8]);
		String a4 = String.valueOf(v[9]) + String.valueOf(v[10]) + String.valueOf(v[11]);
	
		assertEquals(v2[0],v2[1],v2[2]); // verifica que todos os restos ocorrem em mesma quantidade
		assertEquals(a1,a2,a3); // verifica a periodicidade dos restos
		assertEquals(a3,a4); // verifica a periodicidade dos restos
	
	}
	
	
}

