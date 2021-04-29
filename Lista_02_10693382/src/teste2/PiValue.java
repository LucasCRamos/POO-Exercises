package teste2;

public class PiValue{	
	
	public static double arcotan(double x) {
		
		double actan = 0;
		
		for(int i = 0; i < 10000000; i++) {
			
			
			actan = actan + (Math.pow(-1,i)*Math.pow(x, 2*i+1))/(2*i+1);
			
		}
		
		return actan;
				
	}
	
	public static double arcotan2(double x) {
		
		return Math.atan(x);
	}
	
	public static void imprime(double x) {
		
		double pi = PiValue.arcotan(x);
		double pi_2 = PiValue.arcotan2(x);
		
		System.out.println("O valor do arcotangente(" + x + ") pelo método que construímos: " + pi + ",logo π = " + (4*pi));
		System.out.println("O valor do arcotangente("+ x +") pelo método da class Math: " + pi + ", logo π = " + (4*pi_2));
		System.out.println("A diferença entre os valores calculados para π é de: " + (4*pi_2 - 4*pi));
		
	}
	
	public static void main(String[] args) {
		
		double x = 1;
		
		imprime(x);

	
	}
}
