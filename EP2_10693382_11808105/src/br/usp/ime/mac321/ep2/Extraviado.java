package br.usp.ime.mac321.ep2;

public class Extraviado implements EstadoExemplares {

	@Override
	public void emprestimo(Exemplar exemplar, String cpf,  String dataEmprestimo) {
		throw new RuntimeException("O exemplar não está disponível para empréstimo.");

	}

	@Override
	public void devolucao(Exemplar exemplar,String dataDevolucao) {
		exemplar.setEstado(new Disponivel());
		(exemplar.getEmprestimo()).setDataRetornoEfetivo(dataDevolucao);
		System.out.println("Devolução concluída. Exemplar " + exemplar.getIdExemplar()+ " disponível.");
	}

	@Override
	public void renovacao(Exemplar exemplar, String dataRenovacao) {
		(exemplar.getEmprestimo()).prorrogaDataMaximaRetorno( dataRenovacao);
		exemplar.setEstado(new Emprestado());
	}

	@Override
	public String mostraEstado(Exemplar exemplar, String dataVerificacao) {
		return "extraviado";
	}



}
