package teste3;

public class ContaCorrente {
	
	private String nome;
	private int nconta;
	private double saldo;

	public void setNome(String n) {
		
		nome = n;
		
	}

	public String getNome() {
		
		return nome;
		
	}
	
	public ContaCorrente(String nome, int nconta, double saldo) {
		
		this.nome = nome;
		this.nconta = nconta;
		this.saldo = saldo;
	}
	
	public ContaCorrente(String nome, int nconta) {
		
		this.nome = nome;
		this.nconta = nconta;
	}
	
	public String toString() {
		
		return "nome: " + this.nome + ", nconta: " + this.nconta + ", saldo: " + this.saldo;
				
	}
	
	public void imprime() {
	
		System.out.println(toString());
	}
	
}