package br.usp.ime.mac321.lista04.ex4;

// Como o public boolean souNulo() pertence às duas interfaces e são exatamente iguais, não há conflito.

// Se eu tentar implementar o Inteiro meIncremente() ou Inteiro meDecremente(), nenhum erro é acusado, pois
// como o Inteiro implementa as interfaces Incrementavel e Decrementavel, um método do tipo Inteiro será aceito.

public class Inteiro implements Incrementável, Decrementável{

	private int num;
	
	public Inteiro(int num) {
		
		this.num = num;
		
	}
	
	public int getValue() {
		
		return num;
	}

//	@Override
//	public Incrementavel meIncremente() {
//		
//		num = num+1;
//		
//		return null;
//	}
	
	@Override
	public Inteiro meIncremente() {
		
		num = num+1;
		
		return null; // retorno nulo, pois não uso o retorno deste método e sim o retorno do getValue.
	}


//	@Override
//	public Decrementavel meDecremente() {
//		
//		num = num-1;
//		
//		return null;
//	}
	
	@Override
	public Inteiro meDecremente() {
		
		num = num-1;
		
		return null; // retorno nulo, pois não uso o retorno deste método e sim o retorno do getValue.
	}
	
	@Override
	public boolean souNulo() {
		
		if (num == 0) return true;
				
		else return false;
	}

}
