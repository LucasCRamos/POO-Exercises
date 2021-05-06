package teste5;
import java.math.BigInteger;

//As variaveis do tipo BigInteger ocupam mais memória do que as do tipo Integer
//fazendo com que seja necessário um número maior de instruções, aumentando o tempo de execucao

public class TesteTempoBig {
    private final static int TAMANHO = 100000;
    private final static int MAXIT = 10;
    private static BigInteger[] vint = new BigInteger[TAMANHO];

    public static void preenche() {

        for (int i = 0; i < TAMANHO; i++) {
            vint[i] = BigInteger.valueOf(i);
        }
    }

    public static long testeint(int i) {
        BigInteger y = BigInteger.ZERO;
        long inicio = System.currentTimeMillis();
        for (int k = 0; k < MAXIT; k++)
            for (int j = 0; j < TAMANHO; j++) {
                y = y.add(vint[j]); // atribui a y a soma de 1 a TAMANHO-1
            }
        long fim = System.currentTimeMillis();
        System.out.println("int, teste:" + i + ":Tempo gasto: " + (fim - inicio) + "ms");
        return (fim - inicio);
    }

    public static void main(String[] args) {
        long min, med, soma;
        long aux;
        min = Integer.MAX_VALUE;
        soma = 0;
        preenche();
        System.out.println("Teste para 5 iteracoes");
        for (int i = 0; i < 5; i++) {
            aux = TesteTempoBig.testeint(i + 1);
            // os testes devem ser feitos um apos o outro 5 vezes
            if (aux < min)
                min = aux;
            soma += aux;
        }
        med = soma / 5;
        System.out.println("Resultados finais: tempo minimo = " + min + " tempo medio = " + med);
    }
}