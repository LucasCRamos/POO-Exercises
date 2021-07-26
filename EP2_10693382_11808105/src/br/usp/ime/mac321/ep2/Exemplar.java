package br.usp.ime.mac321.ep2;

public class Exemplar {
	
	private String idLivro;
	private String idExemplar;
	private EstadoExemplares estado;
	private Emprestimo emprestimo;
	
	public Exemplar(String idExemplar, String idLivro) {
		this.idExemplar = idExemplar;
		this.idLivro = idLivro;
		estado = new Disponivel();
	}
	
	public String getIdLivro() {
		return idLivro;
	}
	
	public String getIdExemplar() {
		return idExemplar;
	}
	
	public String getEstado(String data) {
		return estado.mostraEstado(this, data);
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	
	public void setEstado(EstadoExemplares estado) {
		this.estado = estado;
	}
	
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	public void emprestimo(String cpf, String dataEmprestimo) {
		this.estado.emprestimo(this,cpf, dataEmprestimo);
	}
	
	public void devolucao(String dataDevolucao) {
		this.estado.devolucao(this, dataDevolucao);
	}
	
	public void renovacao(String dataRenovacao) {
		this.estado.renovacao(this, dataRenovacao);
	}

}
