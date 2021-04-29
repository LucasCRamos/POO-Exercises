package teste5;

public class TestComplex {

	public static void main(String[] args) {
		
		Complex c1 = new Complex(5,4);
		Complex c2 = new Complex(1,3);
		Complex c3 = new Complex(2,5);
		
		System.out.println("---------------PRIMEIROS TESTES---------------");
		//addition test	
		c1.addToMe(c2).addToMe(c3); //c1 = 8+12i
		System.out.println("The sum between the numbers is: " + Math.round(c1.getReal()*100.0)/100.0 + " + " + Math.round(c1.getImaginary()*100.0)/100.0 + "i");
		
		
		//subtraction test
		c1.subtractFromMe(c2).subtractFromMe(c3); //c1 = 5+4i
		System.out.println("The subtraction between the numbers is: " + Math.round(c1.getReal()*100.0)/100.0 + " + " + Math.round(c1.getImaginary()*100.0)/100.0 + "i");
		
		
		//multiplication test
		c1.multiplyByMe(c2).multiplyByMe(c3); //c1 = -109+3i
		System.out.println("The multiplication between the numbers is: " + Math.round(c1.getReal()*100.0)/100.0 + " + " + Math.round(c1.getImaginary()*100.0)/100.0 + "i");
		
		
		//division test
		c1.divideMeBy(c2).divideMeBy(c3); //c1 = 5+4i
		System.out.println("The division between the numbers is: " + Math.round(c1.getReal()*100.0)/100.0 + " + " + Math.round(c1.getImaginary()*100.0)/100.0 + "i");
		
			
		//c1 module test		
		System.out.println("The module of the number: " + Math.round(c1.getReal()*100.0)/100.0 + " + " + Math.round(c1.getImaginary()*100.0)/100.0 + "i is: " + Math.round(c1.module()*100.0)/100.0);
		
		
		//c1 angle test	
		System.out.println("The angle of the number: " + Math.round(c1.getReal()*100.0)/100.0 + " + " + Math.round(c1.getImaginary()*100.0)/100.0 + "i is: "
				+ Math.round(c1.angle() * 100.0) / 100.0 + "°");
		
		
		
		c1.setComplex(5, 4);
		c2.setComplex(1, 3);
		c3.setComplex(2, 5);
		Complex c4 = new Complex();
		
		
		
		System.out.println("---------------SEGUNDOS TESTES---------------");
	
		//addition test	
		c4 = c1.add(c2).add(c3); //c4 = 8+12i
		System.out.println("The sum between the numbers is: " + Math.round(c4.getReal()*100.0)/100.0 + " + " + Math.round(c4.getImaginary()*100.0)/100.0 + "i");
		
		
		//subtraction test
		c4 = c1.sub(c2).sub(c3); //c4 = 2-4i
		System.out.println("The subtraction between the numbers is: " + Math.round(c4.getReal()*100.0)/100.0 + " + " + Math.round(c4.getImaginary()*100.0)/100.0 + "i");
		
		
		//multiplication test
		c4 = c1.mult(c2).mult(c3); //c4 = -109+3i
		System.out.println("The multiplication between the numbers is: " + Math.round(c4.getReal()*100.0)/100.0 + " + " + Math.round(c4.getImaginary()*100.0)/100.0 + "i");
		
		
		//division test
		c4 = c1.div(c2).div(c3); //c4 = -0.07 -0.37i
		System.out.println("The division between the numbers is: " + Math.round(c4.getReal()*100.0)/100.0 + " + " + Math.round(c4.getImaginary()*100.0)/100.0 + "i");
		
			
		//c4 module test		
		System.out.println("The module of the number: " + Math.round(c4.getReal()*100.0)/100.0 + " + " + Math.round(c4.getImaginary()*100.0)/100.0 + "i is: " + Math.round(c4.module()*100.0)/100.0);
		
		
		//c4 angle test	
		System.out.println("The angle of the number: " + Math.round(c4.getReal()*100.0)/100.0 + " + " + Math.round(c4.getImaginary()*100.0)/100.0 + "i is: "
				+ Math.round(c4.angle() * 100.0) / 100.0 + "°");
		

	}
}
