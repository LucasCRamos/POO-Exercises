package br.usp.ime.mac321.ep1.ex1;

abstract public class Evento {
	
	private long evtTime;
	
	public Evento(long eventTime) {
		
		evtTime = eventTime;
	
	}
	
	public boolean pronto() {
		
		return System.currentTimeMillis() >= evtTime;
	
	}
	
	abstract public void ação();
	
	abstract public String descrição();
}