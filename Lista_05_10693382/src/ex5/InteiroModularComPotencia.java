package ex5;
import ex4.InteiroModular;

public class InteiroModularComPotencia extends InteiroModular{

	
	public InteiroModularComPotencia(long valor, long m){
		
		super(valor, m);
	}
	
	public InteiroModularComPotencia elevadoA(long n) {
		this.valor = (long) Math.pow(valor, n);
		return this;
	}
	
	public long getResto() {
		
		return valor%getM();
	}
	
	
}