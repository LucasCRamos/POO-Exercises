package br.usp.ime.mac321.ep1.ex4;

public class Medico {
	
	private int frequencia;
	private String[] drogas = new String[1];
	
	
	public Medico(int frequencia, String droga) {
		
		this.frequencia = frequencia;
		this.drogas[0] = droga;

	}
	
	public int getFreq() {
		
		return frequencia;
		
	}
	
	String decideDroga() {
		
		return drogas[0];
		
	}
	
	long decideDuracaoDroga() {
		
		return 0;
	}

}
