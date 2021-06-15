package ex2;

class NegativeException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public NegativeException(String exception) {
		
		super(exception);
		
	}
	
}

public class Cliente {
	
	private String nome;
	private int nconta;
	private double saldo;
	
	private static int proximoNumero = 1000;
	
	public Cliente(String nome) {
		
		this.nome = nome;
		this.nconta = proximoNumero++;
	}
	
	
	public Cliente(String nome, double saldo) {
		
		this.nome = nome;
		this.saldo = saldo;
		this.nconta = proximoNumero++;
	}
	
	void setSaldo(double saldo) {
		
		this.saldo = saldo;
		
	}
	
	double getSaldo() {
		
		return saldo;
	}
	
	
    public void saque(double valor) {
    	
    
        if (saldo < valor ) throw new NegativeException("Saque inválido, valor maior do que o saldo: " + valor);
        
        else if (valor < 0) throw new NegativeException("Saque inválido, valor negativo: " + valor);
        
        else saldo = saldo - valor;
        	
    }
        	
    public void deposito(double valor) {
    	
        if (valor <= 0 ) throw new NegativeException("Depósito inválido, valor negativo: " + valor);
        
        else saldo = saldo + valor;
        
    }
    
    public void imprime() {
    	
        System.out.println("numero: " + nconta);
        System.out.println("titular: " + nome);
        System.out.print("saldo: " + saldo);
    }
	
    
    public boolean verificaSaldo(double valor) {
    	
    	if (saldo >= valor) return true;
    	
    	else return false;
    	
    }
    
    public boolean verificaNome(String name) {
    	
    	if (nome == name) return true;
    	
    	else return false;
    	
    }
    
    public static void main(String args[]){
		
		Cliente c1 = new Cliente("Lucas",1000);
		
    	try {
    		

			c1.saque(1100);
			c1.deposito(-30);
		
    	}
    	
    	catch(NegativeException e) {
    		
    		System.err.println("Capturada " + e);
    	}
    	
    	finally {
    		
    		if(c1.saldo < 0) {
    			
    			c1.saldo = 0;
    		}
    	}
	}

}





























