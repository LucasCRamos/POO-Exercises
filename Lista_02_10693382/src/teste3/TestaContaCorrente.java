package teste3;

public class TestaContaCorrente {

	public static void main(String[] args) {

		ContaCorrente cc = new ContaCorrente("Lucas", 4269, 1000.000);
		ContaCorrente cc2 = new ContaCorrente("Joana", 3000);
		ContaCorrente cc3 = new ContaCorrente("Maria", 53000);

		cc.imprime();
		cc2.imprime();
		cc3.imprime();

	}

}
