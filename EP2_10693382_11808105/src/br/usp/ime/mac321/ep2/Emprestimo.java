package br.usp.ime.mac321.ep2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Emprestimo {

    private String cpf;
    private String idExemplar;
    private String dataEmprestimo;
    private String dataMaximaRetorno;
    private String dataRetornoEfetivo;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");


    public Emprestimo(String cpf, String idExemplar, String dataEmprestimo) {
        this.cpf = cpf;
        this.idExemplar = idExemplar;
        this.dataEmprestimo = dataEmprestimo;
        dataMaximaRetorno = defineRetorno();
    }

    public void setDataRetornoEfetivo(String data) {
        dataRetornoEfetivo = data;
    }
    
  //Prorroga a data de devolução em um mês 
    public void prorrogaDataMaximaRetorno(String dataRenovacao) {

        LocalDate dataRenovacaoConvertida = LocalDate.parse( dataRenovacao,formatter);

        dataMaximaRetorno = dataRenovacaoConvertida.plusMonths(1).format(formatter);

    }

    private String defineRetorno() {
    	
    	try {
	        LocalDate dataEmprestimoConvertida = LocalDate.parse(dataEmprestimo,formatter);
	
	        String dataRetorno = dataEmprestimoConvertida.plusMonths(1).format(formatter);
	
	        return dataRetorno;
    	}

		catch(DateTimeParseException e) {
			System.err.println("Data inválida");
			return "Data inválida.";
		}

    }

    public String getIdExemplar() {

        return idExemplar;
    }

    public String getCpf() {

        return cpf;
    }

    public String getDataEmprestimo() {

        return dataEmprestimo;
    }

    public String getDataMaximaRetorno() {

        return dataMaximaRetorno;
    }

    public String getDataRetornoEfetivo() {

        return dataRetornoEfetivo;
    }
}