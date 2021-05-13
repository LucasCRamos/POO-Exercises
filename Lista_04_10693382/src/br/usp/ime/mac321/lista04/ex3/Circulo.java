package br.usp.ime.mac321.lista04.ex3;

public class Circulo implements Figura2D {
	
	private double r;
	
	private String cor = "Azul";
	
	public Circulo(double r) {
		
		this.r = r;
	}
	
	@Override
	public double calculaArea() {
		
		return Math.PI*r*r;
	}
	
	@Override
	public double calculaPerimetro() {
		
		return 2*Math.PI*r;
		
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

