package ex4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestaCartaoUtil {
	
	Visa v = new Visa("4123456789128","05/2022");
	Mastercard m = new Mastercard("123456789101112", "03/2023");
	Amex a = new Amex("1234567891011121","04/2029");
	Diners d = new Diners("123456ab78910111","05/2020");
	public static final String CARTAO_ERRO = "Cartão inválido";
	public static final String CARTAO_OK = "Cartão válido";
	
	@Test
	void testaVerificaFormatoOk() {
		assertEquals(CARTAO_OK,v.verificaFormatoOk());
		assertEquals(CARTAO_ERRO,m.verificaFormatoOk());
	}
	
	@Test
	void testaVerificaNumeroOk() {
		assertEquals(CARTAO_OK,v.verificaNumeroOk());
		assertEquals(CARTAO_ERRO,a.verificaNumeroOk());
		
	}

	@Test
	void testaVerificaValidadeOk() {
		assertEquals(CARTAO_OK,m.verificaValidadeOk());
		assertEquals(CARTAO_ERRO,d.verificaValidadeOk());
	
	}
	
	@Test
	void testaFormataNumero() {
		assertEquals("12345678910111",d.formataNumero());
		assertEquals("1234567891011121",a.formataNumero());

	}



}
