package ex1;

public class NumeroNegativoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NumeroNegativoException() {
		
		super("Fatorial de número negativo não existe!");
		
	}
}
