package br.usp.ime.mac321.ep1.ex1;

 // This is just a way to hold Event objects.
class ConjuntoDeEventos {
	
	private Evento[] eventos = new Evento[100];
	private int indice = 0;
	private int proximo = 0;
	
	public void add(Evento e) {
		
	if(indice >= eventos.length)
		return; // (In real life, throw exception)
		eventos[indice++] = e;
	}
	
	public Evento pegaProximo() {
		
		boolean looped = false;
		
		int inicio = proximo;
		
		do {
			proximo = (proximo + 1) % eventos.length;
		// See if it has looped to the beginning:
		if(inicio == proximo) looped = true;
		// If it loops past start, the list
		// is empty:
		if((inicio == (proximo + 1) % eventos.length)
		&& looped)
			return null;
		
		} while(eventos[proximo] == null);
		
			return eventos[proximo];
			
		}
	
		public void removeAtual() {
			
			eventos[proximo] = null;
			
		}
	
	}
	
	public class Controlador {
		
	private ConjuntoDeEventos es = new ConjuntoDeEventos();
	
	public void insere(Evento c) { es.add(c); }
	
	public void run() {
		
	Evento e;
	
		while((e = es.pegaProximo()) != null) {
			
			if(e.pronto()) {
				
				e.ação();
				
				System.out.println(e.descrição());
				
				es.removeAtual();
			}
		}
	}
}