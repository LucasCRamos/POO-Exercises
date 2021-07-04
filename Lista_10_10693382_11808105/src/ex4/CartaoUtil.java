package ex4;

//Programa construído por:

//Lucas Carvalho Ramos (10693382)
//Emilly da Silva Arcanjo (11808105)

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

abstract public class CartaoUtil {

	public static final String CARTAO_ERRO = "Cartão inválido";
	public static final String CARTAO_OK = "Cartão válido";

	protected String numero, validade;

	public CartaoUtil(String numero, String validade) {
		this.numero = numero;
		this.validade = validade;
	}

	public String getNumero() {
		return numero;
	}

	public String getValidade() {
		return validade;
	}

	// remove caracteres não-numéricos
	public String formataNumero() {
		String formatado = "";

		for (int i = 0; i < numero.length(); i++) {
			char c = numero.charAt(i);
			if (Character.isDigit(c)) {
				formatado += c;
			}
		}

		return formatado;
	}

	public String verificaValidadeOk() {

		boolean validadeOK = false;
		Date dataValidade = null;

		try {
			dataValidade = new SimpleDateFormat("MM/yyyy").parse(validade);
		} catch (ParseException e) {
			return CARTAO_ERRO;
		}

		Calendar calValidade = new GregorianCalendar();
		calValidade.setTime(dataValidade);
		// apenas mês e ano são utilizados na validação
		Calendar calTemp = new GregorianCalendar();
		Calendar calHoje = (GregorianCalendar) calValidade.clone();
		calHoje.set(Calendar.MONTH, calTemp.get(Calendar.MONTH));
		calHoje.set(Calendar.YEAR, calTemp.get(Calendar.YEAR));
		validadeOK = calHoje.before(calValidade);

		if (!validadeOK)
			return CARTAO_ERRO;
		else
			return CARTAO_OK;

	}

	public String verificaNumeroOk() {
		int soma = 0;
		int digito = 0;
		int somafim = 0;
		boolean multiplica = false;

		for (int i = numero.length() - 1; i >= 0; i--) {
			digito = Integer.parseInt(numero.substring(i, i + 1));
			if (multiplica) {
				somafim = digito * 2;
				if (somafim > 9) {
					somafim -= 9;
				}
			} else {
				somafim = digito;
			}
			soma += somafim;
			multiplica = !multiplica;
		}

		int resto = soma % 10;

		if (resto == 0) {
			return CARTAO_OK;
		} else {
			return CARTAO_ERRO;
		}
	}

	abstract public String verificaFormatoOk();

}

class Visa extends CartaoUtil {

	public Visa(String numero, String validade) {
		super(numero, validade);
	}

	@Override
	public String verificaFormatoOk() {

		numero = formataNumero();

		if (numero.startsWith("") && (numero.length() == 13 || numero.length() == 16))
			return CARTAO_OK;
		else
			return CARTAO_ERRO;
	}

}

class Mastercard extends CartaoUtil {

	public Mastercard(String numero, String validade) {
		super(numero, validade);
	}

	@Override
	public String verificaFormatoOk() {
		numero = formataNumero();

		if ((numero.startsWith("") && numero.length() == 16))
			return CARTAO_OK;
		else
			return CARTAO_ERRO;

	}

}

class Amex extends CartaoUtil {

	public Amex(String numero, String validade) {
		super(numero, validade);
	}

	@Override
	public String verificaFormatoOk() {
		numero = formataNumero();

		if ((numero.startsWith("") || numero.startsWith("") && numero.length() == 15))
			return CARTAO_OK;
		else
			return CARTAO_ERRO;

	}

}

class Diners extends CartaoUtil {

	public Diners(String numero, String validade) {
		super(numero, validade);
	}

	@Override
	public String verificaFormatoOk() {

		numero = formataNumero();

		if ((numero.startsWith("") || numero.startsWith("") || numero.startsWith("")
				|| numero.startsWith("") && numero.length() == 14))
			return CARTAO_OK;
		else
			return CARTAO_ERRO;

	}

}
