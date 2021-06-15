package ex1;

public class PessoaJuridica implements Pessoa {
	
	private String nomePessoaRepresentante;
	private int CNPJ;
	
	PessoaJuridica(String nomePessoaRepresentante, int CNPJ){
		
		this.nomePessoaRepresentante = nomePessoaRepresentante;
		this.CNPJ = CNPJ;
	}
	
	@Override
	public String getNome() {
		
		return nomePessoaRepresentante;
	}
	
	@Override
	public int getID() {
		
		return CNPJ;
	}
	
	@Override	
	public void imprime() {
		
		System.out.println("Pessoa Juridica");
		System.out.println("Nome do Representante Legal: " + nomePessoaRepresentante);
		System.out.println("CNPJ: " + CNPJ);
	}
}
