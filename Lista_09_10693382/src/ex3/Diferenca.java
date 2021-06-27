package ex3;

//Programa construído por:

//Lucas Carvalho Ramos (10693382)
//Emilly da Silva Arcanjo (11808105)

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//PrintWriter são destinados a dados de texto e tem alguma tradução entre Unicode 
//e a codificação de arquivo da plataforma real. Já os OutputStreams são destinados 
//a dados binários e não fazem essa tradução. 

public class Diferenca {
	
	    public static void main(String[] args) {
	    		  
	        // create random object
	        Random r = new Random();
	  
	        // create byte array
	        byte[] bytes = new byte[10];
	  
	        // put the next byte in the array
	        r.nextBytes(bytes);
	    	
	    	PrintWriter writer = null;
	    	
	    	try {
	    	
	    		writer  = new PrintWriter("print.txt");
	    		
	    		writer.println(bytes);
	    		
	        	System.out.println("PrintWriter: Dados gravados com sucesso");
	    	
	    	}
	    	
	    	catch (FileNotFoundException e){
	    		
	    		e.printStackTrace();
	    	}
	    	
	    	writer.close();
	        
	        FileOutputStream outStream = null;
	        
	        try {
	        
	        	
	        	outStream = new FileOutputStream("out.txt");
	        	outStream.write(bytes);
	        	System.out.println("OutputStream: Dados gravados com sucesso");
	        
	        } 
	        
	        catch(IOException e) {
	        	
	        	System.out.println(e);
	        	
	        }

	}
	    
}

