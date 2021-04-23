package teste1;

public class Fatorial {

	public int calcula(int n) {

		if (n <= 0)
			return 1;

		int fat = 1;

		for (int i = 1; i <= n; i++) {

			fat *= i;

		}

		return fat;

	}

}