package br.usp.ime.mac321.ep1.ex2;

public class Paciente {
	
	private double temperatura; //entre 36 e 37 graus
	private double concentracaoPAC; //entre 100 e 100mil unidades por mm³
	private double aumentoTemperatura; //minimo 5 graus
	private int frequenciaSurtos;
	private double velocidadeAumentoPAC;
	
	double temperaturaInicial;
	double concentracaoInicial;
	
	public double getTemperatura() {
		
		return temperatura;
		
	}
	
	public double getConcentracaoPAC() {
		
		return concentracaoPAC;
		
	}
	
	public double getAumentoTemperatura() {
		
		return aumentoTemperatura;
	}
	
	public int getFrequenciaSurtos() {
		
		return frequenciaSurtos;
		
	}
	
	public double getVelocidadeAumentoPAC() {
		
		return velocidadeAumentoPAC;
		
	}
	
	public Paciente(double temperatura, double concentracaoPAC, double aumentoTemperatura,
			int frequenciaSurtos, double velocidadeAumentoPAC) {
		
		this.temperatura = temperatura;
		this.concentracaoPAC = concentracaoPAC;
		this.aumentoTemperatura = aumentoTemperatura;
		this.frequenciaSurtos = frequenciaSurtos;
		this.velocidadeAumentoPAC = velocidadeAumentoPAC;
		temperaturaInicial = temperatura;
		concentracaoInicial = concentracaoPAC;

	}
	
	//temperatura acima de 41 graus por 1h => morte
	public double valorTemperatura(long tempo) {
		
		if (tempo >= frequenciaSurtos)
		temperatura = temperaturaInicial + aumentoTemperatura;
		
		
		
		if(temperatura >= 41 && tempo >= (frequenciaSurtos+60)) {
			
			temperatura = -1;
			concentracaoPAC = -1;
			
		}
		
		return temperatura;
	}
	
	public double valorConcentracao(long tempo) {	
		
		
		return concentracaoPAC;
		
	}
	
	public boolean estaVivo(long tempo) {
		
			
		if(valorTemperatura(tempo) < 0) return false;
			
		else return true;
		
	}
	
}
