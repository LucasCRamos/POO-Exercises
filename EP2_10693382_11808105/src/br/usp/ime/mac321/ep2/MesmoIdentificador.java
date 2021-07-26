package br.usp.ime.mac321.ep2;

public class MesmoIdentificador extends Exception {
 	
 	@Override 
 	public String toString(){ 
    	return("Dois livros possuem o mesmo valor do campo de identificação.");
 	}
} 