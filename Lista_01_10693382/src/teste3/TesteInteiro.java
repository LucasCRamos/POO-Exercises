// Não tinha main
// Possuía método public Inteiro (construtor) que conflitava com o construtor criado na main

package teste3;

class Inteiro {

	private int i;

	public void setInt(int j) {
		i = j;
	}

	public int getInt() {
		return i;
	}

}

public class TesteInteiro {

	public static void main(String[] args) {
		Inteiro obj = new Inteiro();
		System.out.println(" O objeto contem: " + obj.getInt()); //get.Int() antes do setInt() vale 0 (valor default)
		obj.setInt(4);
		System.out.println(" O objeto contem: " + obj.getInt()); //get.Int() depois do setInt(4) vale 4 (valor setado pelo setInt(4))
	}
}