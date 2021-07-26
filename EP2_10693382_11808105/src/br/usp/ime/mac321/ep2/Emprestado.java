package br.usp.ime.mac321.ep2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Emprestado implements EstadoExemplares {

	@Override
	public void emprestimo(Exemplar exemplar, String cpf,  String dataEmprestimo) {
		throw new RuntimeException("O exemplar não está disponível para empréstimo.");

	}

	@Override
	public void devolucao(Exemplar exemplar, String dataDevolucao) {
		exemplar.setEstado(new Disponivel());
		(exemplar.getEmprestimo()).setDataRetornoEfetivo(dataDevolucao);
		System.out.println("Devolução concluída. Exemplar " + exemplar.getIdExemplar()+ " disponível.");

	}

	@Override
	public void renovacao(Exemplar exemplar, String dataRenovacao) {
		(exemplar.getEmprestimo()).prorrogaDataMaximaRetorno(dataRenovacao);
		
	}

	@Override
	public String mostraEstado(Exemplar exemplar, String dataVerificacao) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
			
			String dataMaximaRetorno = (exemplar.getEmprestimo()).getDataMaximaRetorno();
			LocalDate dataMaximaRetornoConvertida = LocalDate.parse(dataMaximaRetorno,formatter);
			
			LocalDate dataVerificacaoConvertida = LocalDate.parse(dataVerificacao,formatter);
			boolean extraviado = dataMaximaRetornoConvertida.isBefore(dataVerificacaoConvertida);
			
			if (extraviado) {
				exemplar.setEstado(new Extraviado());
				return "extraviado";
			}
		}
		
		catch(DateTimeParseException e) {
			System.err.println("Data inválida");
			return "Data inválida.";
		}
	
		return "emprestado";
	}

}
