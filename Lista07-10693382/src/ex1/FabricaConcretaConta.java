package ex1;

public class FabricaConcretaConta implements FabricaAbstrataConta {
	
	private Pessoa titular;
	private String tipoDaConta;
	private double saldo;
	private Conta cc;
	
	FabricaConcretaConta(String tipoDaConta, Pessoa titular, double saldo){
		
		this.tipoDaConta = tipoDaConta;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	FabricaConcretaConta(String tipoDaConta, Pessoa titular, double saldo, Conta cc){
		
		this.tipoDaConta = tipoDaConta;
		this.titular = titular;
		this.saldo = saldo;
		this.cc = cc;
	}
	
	@Override
	public Conta createConta() {
		
		if (tipoDaConta == "corrente") return new ContaCorrente(titular,saldo);
		
		else if (tipoDaConta == "poupanca") return new ContaPoupanca(cc,saldo);
		
		else if (tipoDaConta == "investimentos") return new ContaInvestimentos(cc,saldo);
		
		return null;
	}
}

