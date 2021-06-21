package ex1;

public class ForaDaFaixaException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ForaDaFaixaException() {
		
		super("Número fora da faixa compreendida pelo int	");
		
	}
}