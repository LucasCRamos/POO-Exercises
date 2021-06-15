package ex1;

interface Conta {

	Pessoa getTitular();
	
	double getSaldo();
	
	String getTipoConta();
	
    void saque(double valor);	
        	
    void deposito(double valor);   	
  
    void imprime();
    
}