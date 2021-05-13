package br.usp.ime.mac321.lista04.ex3;

public class Quadrado implements Figura2D{
	
	private double l;
	
	private String cor = "Azul";
	
	public Quadrado(double l) {
		
		this.l = l;
	}
	
	@Override
	public double calculaArea() {
		
		return l*l;
	}
	
	@Override
	public double calculaPerimetro() {
		
		return 4*l;
		
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
