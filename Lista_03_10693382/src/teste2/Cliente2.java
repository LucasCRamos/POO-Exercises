package teste2;
public class Cliente2 {
	
	private String nome;
	private int nconta;
	private double saldo;
	private boolean bloqueado = false;
	
	private static int numBloq = 0;
	
	private static int proximoNumero = 1000;
	
	public Cliente2(String nome) {
		
		this.nome = nome;
		this.nconta = proximoNumero++;
	}
	
	
	public Cliente2(String nome, double saldo) {
		
		this.nome = nome;
		this.saldo = saldo;
		this.nconta = proximoNumero++;
	}
	
	public boolean getBloqueado() {
		
		return bloqueado;
		
	}
	
	public int getNumBloq() {
		
		return numBloq;
		
	}
	
	
    public void saque(double valor) {
    	
    	saldo = saldo - valor;
    	
        if (saldo >= 0) {
        	   
    		System.out.print("1"); 
    		
        }
        
        else
 
        	System.out.print("0"); 
        	bloqueado = true;
        	numBloq ++;
    }
        	
    public void deposito(double valor) {
    	
        if (valor >= 0 ) {
        	
        	saldo = saldo + valor;
        	System.out.print("1"); 
        	
        }
        
        else
        	
        	System.out.print("0");
        	
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