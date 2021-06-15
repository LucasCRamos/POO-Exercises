package ex1;

public class FabricaConcretaPessoa implements FabricaAbstrataPessoa{
	
	private String tipoDePessoa;
	private String nome;
	private int ID;

	
	FabricaConcretaPessoa(String tipoDePessoa, String nome, int ID){
		
		this.tipoDePessoa = tipoDePessoa;
		this.nome = nome;
		this.ID = ID;
		
	}
	
	FabricaConcretaPessoa(String tipoDePessoa, Pessoa titular, int ID){
		
		this.tipoDePessoa = tipoDePessoa;
		this.nome = titular.getNome();
		this.ID = ID;
		
	}
	
	@Override
	public Pessoa createPessoa() {
		
		if("fisica" == tipoDePessoa) return new PessoaFisica(nome, ID);
		else if ("juridica" == tipoDePessoa) return new PessoaJuridica(nome, ID);
		return null;
		
	}

}
