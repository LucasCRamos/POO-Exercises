package ex3;

import ex2.NumeroAritmetico;

public class InteiroAritmetico extends NumeroAritmetico {
	
	public InteiroAritmetico (long valor) {
		
		this.valor = valor;
		
	}
	
	@Override
	public NumeroAritmetico someMeCom (NumeroAritmetico n) {
		
		this.valor += n.getValue();
		return this;
	}
	
	@Override 
	public NumeroAritmetico subtraiaDeMim (NumeroAritmetico n) {
		
		this.valor -= n.getValue();
		return this;
		
	}
	
	@Override
	public NumeroAritmetico multipliqueMePor (NumeroAritmetico n) {
		
		this.valor *= n.getValue();
		return this;
		
	}
	
	@Override
	public NumeroAritmetico dividaMePor (NumeroAritmetico n) {
		
		this.valor /= n.getValue();
		return this;
		
	}
	

	public boolean equals​(NumeroAritmetico n) {
		
		return mesmoValor(n);
		
	}
	
	@Override
	public String toString() {
		
		return "O valor do número é: " + valor;
		
	}
	
	
}
