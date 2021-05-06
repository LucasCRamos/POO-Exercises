package teste1;
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
	
	
    public void saque(double valor) {
    	
        if (saldo >= valor) 
        	
            saldo = saldo - valor;
        
        else
 
        	System.out.print("Saldo insuficiente"); 
    }
        	
    public void deposito(double valor) {
    	
        if (valor >= 0 ) 
        	
        	saldo = saldo + valor;
        
        else
        	
        	System.out.print("Deposito invalido com valor negativo"); 
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
	
	
}