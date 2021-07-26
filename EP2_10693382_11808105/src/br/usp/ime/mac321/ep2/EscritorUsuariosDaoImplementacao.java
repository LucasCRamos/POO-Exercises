package br.usp.ime.mac321.ep2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EscritorUsuariosDaoImplementacao implements EscritorUsuariosDAO {
	
	private String nomeArquivoLivrosCopia;
	
	public EscritorUsuariosDaoImplementacao(String nomeArquivoLivrosCopia) {
		this.nomeArquivoLivrosCopia = nomeArquivoLivrosCopia;
	}
	
	
	@Override
	public void setAllUsuarios() {
PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(nomeArquivoLivrosCopia , "UTF-8");
			writer.println("CPF,Nome");
			writer.println("123456789-00,Zé da Zilda");
			writer.println("987654321-00,Zilda do Zé");
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
