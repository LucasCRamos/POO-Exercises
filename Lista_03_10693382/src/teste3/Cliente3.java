package teste3;

public class Cliente3 {
		
		private String nome;
		private int nconta;
		private double saldo;
		
		private static int proximoNumero = 1000;
		
		private Cliente3(String nome) {
			
			this.nome = nome;
			this.nconta = proximoNumero++;
		}
		
		
		private Cliente3(String nome, double saldo) {
			
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
	    
	    // Um objeto da nossa classe não pode ser criado de modo direto externamente, então quem desejar criar um objeto do tipo Cliente3
	    // precisará fazer uma referência à nossa classe e utilizar este nosso método estático que possibilitará
	    // ou não a criação deste objeto.
	    
	    public static Cliente3 criaCliente(String name, double valor) {
	    	
	    	if(proximoNumero == 1005) return null;
	    	
		    		
	    	else {
	    		
	    		Cliente3 pessoa = new Cliente3(name, valor);
	    		
	    		return pessoa;
	    	}
	    		

	    }

	    protected void finalize(){
	    	
	    	System.out.println("Adios, amigos!");
	    	proximoNumero--;
	    }
	    
	    public void fimCliente() {
	    	finalize();
	    }
		
		
	}