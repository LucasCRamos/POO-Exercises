package teste2;

public class TestaFatorialBigInteger {

	public static void main(String[] args) {

		FatorialBigInteger f = new FatorialBigInteger();
		

		System.out.println(f.calculaInt(1));
		System.out.println(f.calculaInt(19));
		System.out.println(f.calculaInt(20));
		System.out.println(f.calculaInt(30));
		System.out.println(f.calculaInt(50));
		System.out.println(f.calculaInt(100));
		
		System.out.println(f.calculaBigInt(f.calculaInt(1)));	
		System.out.println(f.calculaBigInt(f.calculaInt(2)));	
		System.out.println(f.calculaBigInt(f.calculaInt(3)));	
		System.out.println(f.calculaBigInt(f.calculaInt(4)));	
		System.out.println(f.calculaBigInt(f.calculaInt(5)));	
		System.out.println(f.calculaBigInt(f.calculaInt(6)));	
		

	}

}
