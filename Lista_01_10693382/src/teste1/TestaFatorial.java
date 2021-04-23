package teste1;

public class TestaFatorial {

	public static void main(String[] args) {

		Fatorial f = new Fatorial();

		System.out.println(f.calcula(-5) == 1);
		System.out.println(f.calcula(0) == 1);
		System.out.println(f.calcula(1) == 1);
		System.out.println(f.calcula(4) == 24);
		System.out.println(f.calcula(10) == 3628800);
		System.out.println(f.calcula(12) == 479001600);
		System.out.println(f.calcula(15)); //wrong value, f.calcula(15) >>> 2^(32)-1

	}

}