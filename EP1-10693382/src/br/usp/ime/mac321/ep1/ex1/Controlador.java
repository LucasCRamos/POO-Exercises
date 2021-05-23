package br.usp.ime.mac321.ep1.ex1;

 // This is just a way to hold Event objects.
class EventSet {
	
	private Evento[] events = new Evento[100];
	private int index = 0;
	private int next = 0;
	
	public void add(Evento e) {
		
	if(index >= events.length)
		return; // (In real life, throw exception)
		events[index++] = e;
	}
	
	public Evento getNext() {
		
		boolean looped = false;
		
		int start = next;
		
		do {
			next = (next + 1) % events.length;
		// See if it has looped to the beginning:
		if(start == next) looped = true;
		// If it loops past start, the list
		// is empty:
		if((next == (start + 1) % events.length)
		&& looped)
			return null;
		
		} while(events[next] == null);
		
			return events[next];
			
		}
	
		public void removeCurrent() {
			
			events[next] = null;
			
		}
	
	}
	
	public class Controlador {
		
	private EventSet es = new EventSet();
	
	public void insere(Evento c) { es.add(c); }
	
	public void run() {
		
	Evento e;
	
		while((e = es.getNext()) != null) {
			
			if(e.ready()) {
				
				e.ação();
				
				System.out.println(e.descrição());
				
				es.removeCurrent();
			}
		}
	}
}