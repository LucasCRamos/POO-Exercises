package ex1;

public class Transacoes {

	public static void main(String[] args) {
	
	//Criação da pessoa física
	FabricaAbstrataPessoa fabricaPessoaFisica = new FabricaConcretaPessoa("fisica","Lucas Carvalho Ramos", 453178287);
	Pessoa pessoaFisica = fabricaPessoaFisica.createPessoa();
	
	//Criação da Conta corrente da pessoa física
	FabricaAbstrataConta fabricaContaCorrenteFisica = new FabricaConcretaConta("corrente", pessoaFisica, 100);
	Conta ContaCorrentePessoaFisica = fabricaContaCorrenteFisica.createConta();
	ContaCorrentePessoaFisica.imprime();
	
	//Criação da Conta poupança da pessoa física
	FabricaAbstrataConta fabricaContaPoupanca = new FabricaConcretaConta("poupanca", pessoaFisica, 200, ContaCorrentePessoaFisica);
	Conta ContaPoupancaPessoaFisica = fabricaContaPoupanca.createConta();
	ContaPoupancaPessoaFisica.imprime();
	
	//Criação da pessoa jurídica
	FabricaAbstrataPessoa fabricaPessoaJuridica = new FabricaConcretaPessoa("juridica",pessoaFisica, 1823612000);
	Pessoa pessoaJuridica = fabricaPessoaJuridica.createPessoa();
	
	//Criação da Conta corrente da pessoa jurídica
	FabricaAbstrataConta fabricaContaCorrenteJuridica = new FabricaConcretaConta("corrente", pessoaJuridica, 300);
	Conta ContaCorrentePessoaJuridica = fabricaContaCorrenteJuridica.createConta();
	ContaCorrentePessoaJuridica.imprime();
	
	//Criação da Conta de investimentos da pessoa jurídica
	FabricaAbstrataConta fabricaContaInvestimentos = new FabricaConcretaConta("investimentos", pessoaJuridica, 1000, ContaCorrentePessoaJuridica);
	Conta ContaInvestimentosPessoaJuridica = fabricaContaInvestimentos.createConta();
	ContaInvestimentosPessoaJuridica.imprime();
	
	//Regate do dinheiro da Conta de investimentos da pessoa jurídica e transfere para a conta corrente da pessoa jurídica
	((ContaInvestimentos)ContaInvestimentosPessoaJuridica).resgatar();
	ContaCorrentePessoaJuridica.imprime();
	
	//Transferência do valor para a conta corrente da pessoa física
	((ContaCorrente)ContaCorrentePessoaJuridica).transfere("PIX",ContaCorrentePessoaJuridica.getSaldo(),ContaCorrentePessoaFisica);
	ContaCorrentePessoaFisica.imprime();
	
	//Transferência do valor para a conta poupança da pessoa física
	((ContaCorrente)ContaCorrentePessoaFisica).transfere("TED",ContaCorrentePessoaFisica.getSaldo(),ContaPoupancaPessoaFisica);
	ContaPoupancaPessoaFisica.imprime();
	
	}

}
