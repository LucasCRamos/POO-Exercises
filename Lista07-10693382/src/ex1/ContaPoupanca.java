package ex1;

public class ContaPoupanca implements Conta{
	
	private Pessoa titular;
	private Conta cc;
	private double saldo;
	private String tipoDaConta = "poupanca";
	private double juros = 0.005;
	
	public ContaPoupanca(Conta cc, double saldo) {
		
		this.titular = cc.getTitular();
		this.cc = cc;
		this.saldo = saldo;
	}
	
	
	@Override
	public Pessoa getTitular() {
		
		return titular;
	}
	
	@Override
	public double getSaldo() {
		
		return saldo;
	}

	@Override
	public String getTipoConta() {
		
		return tipoDaConta;
	}
	
	@Override
    public void saque(double valor) {
    	
    
        if (saldo < valor ) throw new RuntimeException("Saque inválido, valor maior do que o saldo: " + valor);
        
        else if (valor < 0) throw new RuntimeException("Saque inválido, valor negativo: " + valor);
        
        else saldo = saldo - valor;
        	
    }
    
	@Override
    public void deposito(double valor) {
    	
        if (valor <= 0 ) throw new RuntimeException("Depósito inválido, valor negativo: " + valor);
        
        else saldo = saldo + valor;
        
    }
    
	@Override
    public void imprime() {
    	
    	System.out.println("Conta Poupança");
        titular.imprime();
        System.out.println("Saldo da conta: " + saldo + " reais\n");
    }
}
