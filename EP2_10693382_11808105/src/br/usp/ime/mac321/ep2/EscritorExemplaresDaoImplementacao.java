package br.usp.ime.mac321.ep2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EscritorExemplaresDaoImplementacao implements EscritorExemplaresDAO {
	
private String nomeArquivoLivrosCopia;
	
	public EscritorExemplaresDaoImplementacao(String nomeArquivoLivrosCopia) {
		this.nomeArquivoLivrosCopia = nomeArquivoLivrosCopia;
	}
	

	@Override
	public void setAllExemplares() {
		
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(nomeArquivoLivrosCopia , "UTF-8");
			writer.println("IdExemplar,IdLivro");
			writer.println("E001,1234X");
			writer.println("E002,1234X");
			writer.println("E003,1234X");
			writer.println("E004,4321Y");
			writer.println("E005,4321Y");
			writer.println("E006,2468Z");
		} 
		catch (FileNotFoundException e) {
			System.err.println(e);
		} 
		catch (UnsupportedEncodingException e) {
			
			System.err.println(e);
		}
		finally {
			writer.close();
		}
	}

}
