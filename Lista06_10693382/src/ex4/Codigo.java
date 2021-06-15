package ex4;

class Excecoes extends Exception{
	
	private static final long serialVersionUID = 1L;
	String auxiliar;
	
	Excecoes(String auxiliar){
		this.auxiliar = auxiliar;
	}
	
	@Override
	public String toString() {
		
		return (auxiliar + " (" + super.toString() + ")");
		
	}
	
}
	
public class Codigo {

	void recebeCodigo(String codigo) throws Exception {
		
		String aux,aux3;
		
		int aux2;
		
		//VERIFICAÇÃO DA PRIMEIRA PALAVRA
		
		if (codigo.indexOf("matriz") != 0) {
			
			throw new Excecoes("A primeira palavra é diferente de matriz");
		}
		
		aux = codigo.substring(codigo.indexOf(" ")+1);
		
		//VERIFICAÇÃO DO TIPO
		
		if ((aux.indexOf("0-1") != 0) && (aux.indexOf("int")) != 0 && (aux.indexOf("double") != 0)) {
			
			throw new Excecoes("O tipo é diferente do esperado");
		}
		
		//VERIFICAÇÃO DO NÚMERO DE LINHAS
		
		aux3 = aux;
		
		aux = aux.substring(aux.indexOf(" ")+1,aux.lastIndexOf(" "));		

		
		try {
			
			aux2 = Integer.parseInt(aux);
		
			
			if(aux2 <= 0) {
				
				throw new Excecoes("O número de linhas é inválido");
			}
			
		}
		
		catch(Exception e) {
			
			throw new Excecoes("O número de linhas é inválido");
		}
		
		//VERIFICAÇÃO DO NÚMERO DE COLUNAS
		
		
		aux3 = aux3.substring(aux3.lastIndexOf(" ")+1);
			
			
		try {
			
			aux2 = Integer.parseInt(aux3);
			
			if(aux2 <= 0) {
				
				throw new Excecoes("O número de colunas é inválido");
			}
			
		}
		
		catch(Exception e) {
			
			throw new Excecoes("O número de colunas é inválido");
		}
		
	}

	
	public static void main(String args[]) throws Exception{
		
		Codigo codigo = new Codigo();
		
		try {
			
			codigo.recebeCodigo("MATRIZ int 1 4");
			
		}
		
		catch(Excecoes e) {
			
			System.err.println(e);
		}

		
	
	}
	
}


