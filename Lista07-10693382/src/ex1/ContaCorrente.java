package ex1;

public class ContaCorrente implements Conta{
	
	private Pessoa titular;
	private double saldo;
	private String tipoDaConta = "corrente";
	private int talaoDeCheques = 30;
	
	public ContaCorrente(Pessoa titular, double saldo) {
		
		this.titular = titular;
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
    		
    	System.out.println("Conta Corrente");
    	titular.imprime();
        System.out.println("Saldo da conta: " + saldo + " reais\n");
    }
    
    public void usarTalaoDeCheques() {
    	
    	if(talaoDeCheques > 1) talaoDeCheques--;
    		
    	else throw new RuntimeException("Cheques acabaram");
    }
    
	public void transfere(String codigo, double valor, Conta cc) {
		
		if (codigo == "PIX" || codigo == "TED" || codigo == "DOC") {
			
			saque(valor);
			
			if(cc.getTipoConta() == "corrente") {
			
				((ContaCorrente)cc).deposito(valor);
			
			}
			
			else if (cc.getTipoConta() == "poupanca") {
				
				cc.deposito(valor);
			}
			
			else throw new RuntimeException("Tipo de Conta Destino é inválido");

		}
		
		System.out.println("Operação: Transferência no valor de " + valor +" reais!");
	}
}