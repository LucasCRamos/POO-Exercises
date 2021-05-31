package br.usp.ime.mac321.ep1.ex4;

public class Paciente {
	
	private double temperatura;
	private double concentracaoPAC;
	private double aumentoTemperatura;
	private int frequenciaSurtos;
	private double velocidadeAumentoPAC;
	
	double temperaturaBasal;
	double concentracaoBasal;
	
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
		temperaturaBasal = temperatura;
		concentracaoBasal = concentracaoPAC;

	}
	
	
	public double valorTemperatura(long tempo, double velocidadeReducaoTemperatura, long instanteInicial) {
		
		double tempAuxiliar = 0;
		
		if ((tempo >= 120 && tempo <= 140)) {

								
			temperatura = temperaturaBasal + aumentoTemperatura*Math.pow(Math.E,-velocidadeReducaoTemperatura*((tempo-instanteInicial)));
			

		}
		
		if(tempo >= 210 && tempo <= 230) {
			
			temperatura = temperaturaBasal + aumentoTemperatura*Math.pow(Math.E,-velocidadeReducaoTemperatura*((tempo-instanteInicial-70)));
			
		}

			
		if(tempo == 240) {
			
			tempAuxiliar = temperaturaBasal + aumentoTemperatura*Math.pow(Math.E,-velocidadeReducaoTemperatura*((tempo-instanteInicial-80)));
			
			temperatura = tempAuxiliar + 5;
			
		}
		
		if(tempo > 280 && tempo <= 300) {
			
			tempAuxiliar = temperaturaBasal + aumentoTemperatura*Math.pow(Math.E,-velocidadeReducaoTemperatura*((40)));
			
			temperatura = tempAuxiliar + aumentoTemperatura*Math.pow(Math.E,-velocidadeReducaoTemperatura*((tempo-instanteInicial-160)));
			
		}
			
		
	return temperatura;
	
	}
	
	
	public double valorConcentracao(long tempo, double velocidadeReducaoConcentracao, long instanteInicial) {
		
		double concentracaoInicial = 0;
		
		double concentracaoAuxiliar = 0;
		
		double concentracaoAuxiliar2 = 0;
		
		double concentracaoAuxiliar3 = 0;
		
		double concentracaoAuxiliar4 = 0;
	
		
		if ((tempo >= 120 && tempo <= 140)) {
			
				
				concentracaoPAC = concentracaoBasal*Math.pow(Math.E,-velocidadeReducaoConcentracao*((tempo-instanteInicial)));
				
		}
			
			
		if (tempo > 140 && tempo < 210){
			
				concentracaoInicial = concentracaoBasal*Math.pow(Math.E,-velocidadeReducaoConcentracao*(20)); //concentracao no momento em que cessou o medicamento
				
				
				concentracaoPAC = concentracaoBasal - (concentracaoBasal-concentracaoInicial)*Math.pow(Math.E,-velocidadeAumentoPAC*(tempo-(instanteInicial+20)));
			
				
			}
		
		if(tempo >= 210 && tempo <= 230) {
			
			concentracaoAuxiliar = concentracaoBasal*Math.pow(Math.E,-velocidadeReducaoConcentracao*(20));
			
			concentracaoInicial = concentracaoBasal - (concentracaoBasal-concentracaoAuxiliar)*Math.pow(Math.E,-velocidadeAumentoPAC*(70));
			
			concentracaoPAC = concentracaoInicial*Math.pow(Math.E,-velocidadeReducaoConcentracao*((tempo-(instanteInicial+90))));
			
		}
		
		if(tempo > 230 && tempo < 280) {
			
			
			concentracaoAuxiliar = concentracaoBasal*Math.pow(Math.E,-velocidadeReducaoConcentracao*(20));
			
			concentracaoInicial = concentracaoBasal - (concentracaoBasal-concentracaoAuxiliar)*Math.pow(Math.E,-velocidadeAumentoPAC*(70));
			
			concentracaoAuxiliar2 = concentracaoInicial*Math.pow(Math.E,-velocidadeReducaoConcentracao*(20));
			
			
			concentracaoPAC = concentracaoBasal - (concentracaoBasal-concentracaoAuxiliar2)*Math.pow(Math.E,-velocidadeAumentoPAC*(tempo-(instanteInicial+110)));
		}
		
		
		if(tempo > 280 && tempo <= 300) {
			
			concentracaoAuxiliar = concentracaoBasal*Math.pow(Math.E,-velocidadeReducaoConcentracao*(20));
			
			concentracaoInicial = concentracaoBasal - (concentracaoBasal-concentracaoAuxiliar)*Math.pow(Math.E,-velocidadeAumentoPAC*(70));
			
			concentracaoAuxiliar2 = concentracaoInicial*Math.pow(Math.E,-velocidadeReducaoConcentracao*(20));
			
			concentracaoAuxiliar3 = concentracaoBasal - (concentracaoBasal-concentracaoAuxiliar2)*Math.pow(Math.E,-velocidadeAumentoPAC*(50));
					
			concentracaoPAC = concentracaoAuxiliar3*Math.pow(Math.E,-velocidadeReducaoConcentracao*((tempo-(instanteInicial+160))));
			
		}
		
		if(tempo > 300) {
			
			concentracaoAuxiliar = concentracaoBasal*Math.pow(Math.E,-velocidadeReducaoConcentracao*(20));
			
			concentracaoInicial = concentracaoBasal - (concentracaoBasal-concentracaoAuxiliar)*Math.pow(Math.E,-velocidadeAumentoPAC*(70));
			
			concentracaoAuxiliar2 = concentracaoInicial*Math.pow(Math.E,-velocidadeReducaoConcentracao*(20));
			
			concentracaoAuxiliar3 = concentracaoBasal - (concentracaoBasal-concentracaoAuxiliar2)*Math.pow(Math.E,-velocidadeAumentoPAC*(50));
			
			concentracaoAuxiliar4 = concentracaoAuxiliar3*Math.pow(Math.E,-velocidadeReducaoConcentracao*(20));
			
			concentracaoPAC = concentracaoBasal - (concentracaoBasal-concentracaoAuxiliar4)*Math.pow(Math.E,-velocidadeAumentoPAC*(tempo-(instanteInicial+180)));
			
			
		}
		
		
		return concentracaoPAC;
		
	}
	
	public boolean estaVivo(long tempo, double velocidadeReducaoTemperatura, double velocidadeReducaoConcentracao, long instanteInicial) {
		
			
			return true;
		
	}
	
}



