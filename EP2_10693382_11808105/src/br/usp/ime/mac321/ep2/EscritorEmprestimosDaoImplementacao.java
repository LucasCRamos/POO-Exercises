package br.usp.ime.mac321.ep2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EscritorEmprestimosDaoImplementacao implements EscritorEmprestimosDAO{

	private String nomeArquivoLivrosCopia;
	
	public EscritorEmprestimosDaoImplementacao(String nomeArquivoLivrosCopia) {
		this.nomeArquivoLivrosCopia = nomeArquivoLivrosCopia;
	}
	

	@Override
	public void setAllEmprestimos() {

		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(nomeArquivoLivrosCopia , "UTF-8");
			writer.println("CPF,IdExemplar,DataEmprestimo,DataRetorno,DataRetornado");
			writer.println("123456789-00,E001,02/02/20,02/03/20,01/03/20");
			writer.println("123456789-00,E002,01/07/21,01/08/21,");
			writer.println("987654321-00,E001,20/02/21,20/03/21,");
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
