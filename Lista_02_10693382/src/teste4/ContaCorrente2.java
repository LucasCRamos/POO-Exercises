package teste4;

public class ContaCorrente2 {
	
	private String nome;
	private int nconta;
	private double saldo;	
	public static String nameOfBank = "BancoCentral";

	public void setNome(String n) {
		
		nome = n;
		
	}

	public String getNome() {
		
		return nome;
		
	}
	
	public ContaCorrente2(String nome, int nconta, double saldo) {
		
		this.nome = nome;
		this.nconta = nconta;
		this.saldo = saldo;
	}
	
	public ContaCorrente2(String nome, int nconta) {
		
		this.nome = nome;
		this.nconta = nconta;
	}
	
	public String toString() {
		
		return "Nome: " + this.nome + ", nconta: " + this.nconta + ", saldo: " + this.saldo + ", banco: " + nameOfBank;
				
	}
	
	public void imprime() {
	
		System.out.println(toString());
	}
	
}