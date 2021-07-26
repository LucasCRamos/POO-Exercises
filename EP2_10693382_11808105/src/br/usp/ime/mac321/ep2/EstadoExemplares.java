package br.usp.ime.mac321.ep2;

public interface EstadoExemplares {
	
	public void emprestimo(Exemplar exemplar,String cpf, String dataEmprestimo);
	public void devolucao(Exemplar exemplar, String dataDevolucao);
	public void renovacao(Exemplar exemplar, String dataRenovacao);
	public String mostraEstado(Exemplar exemplar, String dataVerificacao);

}
