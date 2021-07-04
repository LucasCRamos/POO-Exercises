package ex3;

//Programa construído por:

//Lucas Carvalho Ramos (10693382)
//Emilly da Silva Arcanjo (11808105)

//O segundo código é superior, pois dispensa comentários acerca do que se trata o valor de 9,81.
//Além disso, caso seja necessário utilizar o valor da constante gravitacional em outros cálculos,
//basta utilizar a constante criada.

public class Q3 {
	
	double energiaPotencial1(double massa, double altura) {
		// 9.81 é a constante gravitacional.
		return massa * 9.81 * altura;
	}

	static final double CONSTANTE_GRAVITACIONAL = 9.81;

	double energiaPotencial2(double massa, double altura) {
		return massa * CONSTANTE_GRAVITACIONAL * altura;
	}

}


