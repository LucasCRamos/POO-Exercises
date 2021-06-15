package ex1;

public class ContaInvestimentos implements Conta{
	
	private Pessoa titular;
	private Conta cc;
	private double saldo;
	private String tipoDaConta = "investimentos";
	
	public ContaInvestimentos(Conta cc, double saldo) {
		
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
    public void imprime() {
    	
    	System.out.println("Conta de Investimentos");
        titular.imprime();
        System.out.println("Saldo da conta: " + saldo + " reais\n");
    }
	
	@Override
    public void deposito(double valor) { //investir
    	
        if (valor <= 0 ) throw new RuntimeException("Depósito inválido, valor negativo: " + valor);
        
        else saldo = saldo + valor;
        
    }
	        
	public void resgatar() { //resgatar
		
		double aux = saldo;
		
		System.out.println("Operação: Resgate no valor de: " + aux + " reais!");
		
		saque(aux);
		
		cc.deposito(aux);
		
	}
}
