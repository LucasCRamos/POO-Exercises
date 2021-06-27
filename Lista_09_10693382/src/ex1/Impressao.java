package ex1;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;

//Programa construído por:

//Lucas Carvalho Ramos (10693382)
//Emilly da Silva Arcanjo (11808105)

/*Como é possível ver, o tempo de execução da impressão em um arquivo
 * é menor do que o tempo de execução da impressão no console. Isso ocorre
 * porque o out do comando System.out.println é uma instância do tipo PrintStream.
 * Diferente da classe PrintStream, na classe PrintWriter, se o flushing 
 * automático estiver habilitado, este será feito apenas quando um dos 
 * métodos println, printf ou format for chamado, em vez de sempre que um 
 * caractere de nova linha for gerado. Esses métodos usam a própria noção 
 * da plataforma de separador de linha, em vez do caractere de nova linha.
*/

public class Impressao {

	public static void main(String[] args) {
		
		long timePrintWriter = 0;
		long timeConsole = 0;
		
		try {
			
			PrintWriter writer = new PrintWriter("teste.txt", "UTF-8");
			
			long tStart = System.currentTimeMillis();	
			
			for(int i = 0; i < 100000; i++) {
				
				writer.println("TESTE");

			}
			
			long tEnd = System.currentTimeMillis();
			
			timePrintWriter = tEnd - tStart;     
	        
			writer.close();
			
		}
		
		catch(FileNotFoundException | UnsupportedEncodingException e) {
			
			System.out.println(e);
		}
		
		try {
			
			long tStart = System.currentTimeMillis();	
			
			for(int i = 0; i < 100000; i++) {
				
				System.out.println("TESTE");

			}
			
			long tEnd = System.currentTimeMillis();
			
			timeConsole = tEnd - tStart;
	        		
		}
		
		catch(Exception e) {
			
			System.out.println(e);
		}
		
		finally{
			
			System.out.println("Tempo de Execução imprimindo em um arquivo = "+timePrintWriter+" ms");
	        System.out.println("Tempo de Execução imprimindo na saída do terminal = "+timeConsole+" ms");
		}

	}

}