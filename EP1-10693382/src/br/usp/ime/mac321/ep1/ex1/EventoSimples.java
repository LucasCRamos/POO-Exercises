package br.usp.ime.mac321.ep1.ex1;

public class EventoSimples extends Evento {
	
	public EventoSimples(long eventTime) {
		super(eventTime);
	}

	@Override
	public void ação() {
		System.out.println("Ação!");
		
	}

	@Override
	public String descrição() {
		return "Nada";
	}

}
