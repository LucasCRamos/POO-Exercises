package ex2;

public abstract class NumeroAritmetico {
	
	protected long valor;
	
	public long getValue() {
		
		return valor;
	}
	
	public final boolean mesmoValor (NumeroAritmetico n) {
		
		return n.valor == this.valor;
		
	}
	
	public abstract NumeroAritmetico someMeCom (NumeroAritmetico n);
	
	public abstract NumeroAritmetico subtraiaDeMim (NumeroAritmetico n);
	
	public abstract NumeroAritmetico multipliqueMePor (NumeroAritmetico n);
	
	public abstract NumeroAritmetico dividaMePor (NumeroAritmetico n);


}
