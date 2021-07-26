package br.usp.ime.mac321.ep2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Disponivel implements EstadoExemplares {

	@Override
	public void emprestimo(Exemplar exemplar, String cpf, String dataEmprestimo) {
		exemplar.setEstado(new Emprestado());
		exemplar.setEmprestimo(new Emprestimo(cpf, exemplar.getIdExemplar(), dataEmprestimo));
		System.out.println("Exemplar " + exemplar.getIdExemplar()+ " emprestado");
	}

	@Override
	public void devolucao(Exemplar exemplar, String dataDevolucao) {
		throw new RuntimeException("O livro não está emprestado.");

	}

	@Override
	public void renovacao(Exemplar exemplar, String dataRenovacao) {
		throw new RuntimeException("O livro não está emprestado.");
		
	}

	@Override
	public String mostraEstado(Exemplar exemplar, String dataVerificacao) {
		
		try {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate dataVerificacaoConvertida = LocalDate.parse(dataVerificacao,formatter);
		
		}
		catch(DateTimeParseException e) {
			System.err.println("Data inválida");
			return "Data inválida.";
		}
		
		return "disponivel";
	
	}

}
