package br.usp.ime.mac321.ep1.ex4;

public class Droga {
	
	private double velocidadeReducaoTemperatura;
	private double velocidadeReducaoConcentracao;
	
	public Droga(double velocidadeReducaoTemperatura, double velocidadeReducaoConcentracao) {
		
		this.velocidadeReducaoTemperatura = velocidadeReducaoTemperatura;
		this.velocidadeReducaoConcentracao = velocidadeReducaoConcentracao;

	}
	
	public double getVelRedTemp() {
		
		return velocidadeReducaoTemperatura;
	}
	
	public double getVelRedConc() {
		
		return velocidadeReducaoConcentracao;
	}

}
