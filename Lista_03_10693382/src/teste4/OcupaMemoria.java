package teste4;

//À medida que um novo objeto é criado, mais memória é dedicada para armazenar seus atributos
//Quando o tamanho do vetor "a" aumenta, mais rapidamente essa memória é consumida e mais rapidamente o GC será requerido
//Fazendo com que se tenha uma menor quantidade de objetos criados.

//Ao usar o System.gc(), antecipamos a aparição do Garbage Collector e, a depender de onde ele é chamado, ainda menor será
//a quantidade de objetos criados, pois eles podem ser coletados antes do normal.

public class OcupaMemoria {
	static int quantos = 0;
	static boolean finalizou = false;
	double a[] = new double[1000]; // apenas para ocupar espaco

	public OcupaMemoria() {
		quantos++;
	}

	protected void finalize() {
		if (!finalizou) {
			System.out.println("Finalizou uma vez após criar " + quantos + " objetos");
			finalizou = true; // nao imprime mais mensagens
		}
	}

	public static void teste() {
		while (OcupaMemoria.finalizou == false)
			new OcupaMemoria();
	}
	
	public static void main(String [] args) {
		OcupaMemoria.teste();
	}
}