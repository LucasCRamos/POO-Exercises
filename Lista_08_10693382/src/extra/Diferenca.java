//Strings são imutáveis, quando concatenamos strings, na verdade
//estamos criando um novo objeto na memória.
	
//Existe também a StringBuilder, que é uma maneira mais adequada e mais rápida
//de concatenar strings.

//A StringBuffer, por sua vez, é muito similar à StringBuilder, mas se vale
//da ideia de Thread-Safe, pois nela os métodos são sincronizados, evitando
//que não haja erro quando várias threads desejarem acessar o mesmo recurso,
//por isso, sua concatenação é levemente mais lenta que a do StringBuilder,
//mas muito mais rápida do que a concatenação de Strings com o operador "+".

package extra;

public class Diferenca {
	
	public static void main (String[] args) {
	
		//STRING
		
		String str = new String ("");
		
		long tStart = System.currentTimeMillis();	
		
		for(int i = 0; i <= 100000; i++) {
			
			str += "a";
		}
		
		long tEnd = System.currentTimeMillis();
		
		long tResult = tEnd - tStart;

        System.out.println("Tempo de Execução com operador '+' = "+tResult+" ms");
		
		
        //STRINGBUFFER
        StringBuffer strBuffer = new StringBuffer ("");
		
		tStart = System.currentTimeMillis();	
		
		for(int i = 0; i <= 100000; i++) {
			
			strBuffer.append("a");
		}
		
		tEnd = System.currentTimeMillis();
		
		tResult = tEnd - tStart;

        System.out.println("Tempo de Execução com StringBuffer = "+tResult+" ms");
        
        
        //STRINGBUILDER
        StringBuilder strBuilder = new StringBuilder ("");
		
		tStart = System.currentTimeMillis();	
		
		for(int i = 0; i <= 100000; i++) {
			
			strBuilder.append("a");
		}
		
		tEnd = System.currentTimeMillis();
		
		tResult = tEnd - tStart;

        System.out.println("Tempo de Execução com StringBuilder = "+tResult+" ms");
        
	}
	
}
