package teste2;

import java.math.BigInteger;

public class FatorialBigInteger {

	public BigInteger calculaInt(int n) {

		if (n <= 0) {
			return BigInteger.ONE;
		}

		BigInteger fat = BigInteger.valueOf(n);

		BigInteger aux = BigInteger.valueOf(n - 1);

		BigInteger b1 = BigInteger.valueOf(1);

		for (BigInteger i = aux; (i.compareTo(b1) == 0 || i.compareTo(b1) == 1); i = i.subtract(b1)) {

			fat = fat.multiply(i);

		}

		return fat;

	}

	public BigInteger calculaBigInt(BigInteger n) {

		BigInteger b0, b1;

		b0 = BigInteger.valueOf(0);

		b1 = BigInteger.valueOf(1);

		if (n.compareTo(b0) == 0 || n.compareTo(b0) == -1) {
			return BigInteger.ONE;
		}

		BigInteger fat = n;

		BigInteger aux = n.subtract(b1);

		for (BigInteger i = aux; (i.compareTo(b1) == 0 || i.compareTo(b1) == 1); i = i.subtract(b1)) {

			fat = fat.multiply(i);

		}

		return fat;

	}

}
