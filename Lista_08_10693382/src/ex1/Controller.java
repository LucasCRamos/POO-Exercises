package ex1;

public class Controller{

	static public int calcula(int n) throws NumeroNegativoException, ForaDaFaixaException{
		
		if (n < 0) throw new NumeroNegativoException();
		
		else if (n > 12) throw new ForaDaFaixaException();
		
		int fat = 1;

		for (int i = 1; i <= n; i++) {

			fat *= i;

		}

		return fat;

	}

}