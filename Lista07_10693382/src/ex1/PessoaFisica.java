package ex1;

public class PessoaFisica implements Pessoa{
	
	private String nomePessoaFisica;
	private int CPF;
	
	PessoaFisica(String nomePessoaFisica, int CPF){
		
		this.nomePessoaFisica = nomePessoaFisica;
		this.CPF = CPF;
	}
	
	@Override
	public String getNome() {
		
		return nomePessoaFisica;
	}
	
	@Override
	public int getID() {
		
		return CPF;
	}
	
	@Override	
	public void imprime() {
		
		System.out.println("Pessoa Fisica");
		System.out.println("Nome do titular: " + nomePessoaFisica);
		System.out.println("CPF: " + CPF);
	}
}
