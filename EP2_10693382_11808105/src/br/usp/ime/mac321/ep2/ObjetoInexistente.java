package br.usp.ime.mac321.ep2;

public class ObjetoInexistente extends Exception {
 	
	private String mensagem;

	 ObjetoInexistente(String mensagem){  //Construtor
    	this.mensagem = mensagem;
 	}
 	
 	@Override 
 	public String toString(){ 
    	return(mensagem);
 	}
} 