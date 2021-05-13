package br.usp.ime.mac321.lista04.ex3;

public class Retangulo implements Figura2D {
	
	private double a;
	
	private double b;
	
	private String cor = "Azul";
	
	public Retangulo(double a, double b) {
		
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double calculaArea() {
		
		return a*b;
		
	}
	
	@Override
	public double calculaPerimetro() {
		
		return 2*(a+b);
	}
	
	@Override
	public void mudaCor (String cor) {
		
		this.cor = cor;
	}
	
	@Override
	public String pegaCor() {
		
		return cor;
		
	}
	
}
