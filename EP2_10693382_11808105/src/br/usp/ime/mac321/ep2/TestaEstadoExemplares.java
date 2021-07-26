package br.usp.ime.mac321.ep2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestaEstadoExemplares {
	
	static Exemplar e;
	
	@BeforeAll
	public static void setUp(){
		
		e  = new Exemplar("E001","1234X");
	}
	
	@Test
	void testaDisponivelEmprestado(){
		assertEquals("disponivel", e.getEstado("06/07/21"));	
		
		e.emprestimo("123456789-00", "06/07/21");
		assertEquals("emprestado", e.getEstado("06/07/21"));
		
		assertEquals("emprestado", e.getEstado("21/07/21"));
		assertEquals("extraviado", e.getEstado("07/08/21"));
		
		e.renovacao("07/08/21"); //nova data: 07/09/21
		assertEquals("emprestado", e.getEstado("08/08/21"));
		
		assertEquals("extraviado", e.getEstado("08/09/21"));
		
		e.devolucao("08/09/21");
		assertEquals("disponivel", e.getEstado("08/09/21"));
		
	}

}
