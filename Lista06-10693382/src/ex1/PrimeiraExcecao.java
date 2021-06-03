package ex1;

public class PrimeiraExcecao {
	
	static void geraPau() {
		
			
		int[] vetor = new int[1];
		vetor[2] = 3;
				
	}
	
	public static void pegaPau() {
		
		try {
			
			PrimeiraExcecao.geraPau();
		}
		
		catch(ArrayIndexOutOfBoundsException e) {
			
			System.err.println("Peguei");
		}
		
	}
	
	public static void main(String args[]){
		
		pegaPau();
	}

}
