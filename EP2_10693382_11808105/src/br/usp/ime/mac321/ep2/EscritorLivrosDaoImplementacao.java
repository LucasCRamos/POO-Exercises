package br.usp.ime.mac321.ep2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EscritorLivrosDaoImplementacao implements EscritorLIvrosDAO {
	
	private String nomeArquivoLivrosCopia;
	
	public EscritorLivrosDaoImplementacao(String nomeArquivoLivrosCopia) {
		this.nomeArquivoLivrosCopia = nomeArquivoLivrosCopia;
	}
	
	@Override
	public void setAllLivros() {

		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(nomeArquivoLivrosCopia , "UTF-8");
			writer.println("IdLivro,Titulo,Autores,Ano,Editora,Edição,Idioma");
			writer.println("1234X,Lógica para Computação,Flavio Correa;Marcelo Finger;Ana Mello,2017,Cengage,2,português");
			writer.println("4321Y,Calculo Diferencia y Integral,Nikolai Piskunov,1969,Mir,1,espanhol");
			writer.println("2468Z,“1984”,George Orwell,1948,Penguin,1,inglês");
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
