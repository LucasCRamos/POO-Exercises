package br.usp.ime.mac321.ep1.ex2;

public class Paciente {
	
	private double temperatura; //entre 36 e 37 graus
	private double concentracaoPAC; //entre 100 e 100mil unidades por mm³
	private double aumentoTemperatura; //minimo 5 graus
	private double frequenciaSurtos;
	private double velocidadeAumentoPAC;
	
	public Paciente(double temperatura, double concentracaoPAC, double aumentoTemperatura,
			double frequenciaSurtos, double velocidadeAumentoPAC) {
		
		this.temperatura = temperatura;
		this.concentracaoPAC = concentracaoPAC;
		this.aumentoTemperatura = aumentoTemperatura;
		this.frequenciaSurtos = frequenciaSurtos;
		this.velocidadeAumentoPAC = velocidadeAumentoPAC;

	}
	
	//temperatura acima de 41 graus por 1h => morte
	double valorTemperatura(double tempo) {
		
		System.out.println("A temperatura do paciente é: " + temperatura);
		
		if(temperatura >= 41) {
			
			temperatura = -1;
			concentracaoPAC = -1;
			
		}
		
		return temperatura;
	}
	
	double valorConcentracao(double tempo) {
		
		System.out.println("A concentração de PAC do paciente é: " + concentracaoPAC);
		
		return concentracaoPAC;
		
	}
	
	boolean estaVivo() {
			
		if(temperatura < 0 && concentracaoPAC < 0) return false;
			
		else return true;
		
	}
	
}
