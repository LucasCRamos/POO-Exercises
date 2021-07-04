package ex1;

//Programa construído por:

//Lucas Carvalho Ramos (10693382)
//Emilly da Silva Arcanjo (11808105)

public class Fatorial {
	
	//n é o valor para o qual se deseja calcular o fatorial
	
	static int calculaFatorial(int n) {
			
		int valorFatorial = n;
		
		if (n < 0) {
			
			System.out.println("Não é possível calcular o fatorial de um número negativo.");
			
			return -1;
		}
		else {
			for (int i = n; i > 1; i--) {
	
				valorFatorial = valorFatorial * (i - 1);
				
			}
			
			
			if (valorFatorial == 0) valorFatorial = 1;
			
			System.out.println(valorFatorial);
			
			return valorFatorial;
		}
		
	}
	

	public static void main(String args[]) {

		calculaFatorial(5);
	}
}
