package ex4;
import ex3.InteiroAritmetico;
import ex2.NumeroAritmetico;

public class InteiroModular extends InteiroAritmetico {
	
	private long m;
	
	public long getM() {
		return m;
	}


	public void setM(long m) {
		this.m = m;
	}
	
	public InteiroModular(long valor, long m){
		
		super(valor);
		this.setM(m);
	}

	
	@Override
	public NumeroAritmetico someMeCom (NumeroAritmetico n) {
		
		this.valor = (this.valor + n.getValue())%(getM());
		return this;
		
	}
	
	@Override 
	public NumeroAritmetico subtraiaDeMim (NumeroAritmetico n) {
		
		this.valor = (this.valor - n.getValue())%(getM());
		return this;
		
	}
	
	@Override
	public NumeroAritmetico multipliqueMePor (NumeroAritmetico n) {
		
		this.valor = (this.valor * n.getValue())%(getM());
		return this;
	}
	
	@Override
	public NumeroAritmetico dividaMePor (NumeroAritmetico n) {
		
		this.valor = (this.valor / n.getValue())%(getM());
		return this;
		
	}
	

	public boolean equals​(InteiroModular n) {
		
		return (valor == n.valor && getM() == n.getM());	
		
	}
	
	@Override
	public String toString() {
		
		return "O valor do número é: " + valor + "\nO valor de m é: " + getM();
		
	}
		
	
}

