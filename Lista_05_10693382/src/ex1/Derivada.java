package ex1;

//o erro acontece, pois o construtor da classe Base não é mais o default sem parâmetros e, portanto, nossa classe derivada
//deve chamar o construtor da classe Base através do super.

class Base {
	
	Base(int a){
		System.out.println("Constrói Base");
	}
}

public class Derivada extends Base {
	Derivada (int b) {
		super(b);
		System.out.println("Constrói Derivada");
	}
	public static void main(String []argc){
		Derivada obj = new Derivada(5);
	}
}

