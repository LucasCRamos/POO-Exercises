package teste4;

public class TestComplex {

	public static void main(String[] args) {
		
		Complex c1 = new Complex();
		Complex c2 = new Complex();
		Complex c3 = new Complex();
		
		//inputs numbers
		c1.setComplex(-7,-2); //used to calculate module and angle
		c2.setComplex(6,8);
	
		//addition test	
		c3=c1.add(c2);
		System.out.println("The sum between the numbers is: " + Math.round(c3.getReal()*100.0)/100.0 + " + " + Math.round(c3.getImaginary()*100.0)/100.0 + "i");
		
		
		//subtraction test
		c3=c1.sub(c2);	
		System.out.println("The subtraction between the numbers is: " + Math.round(c3.getReal()*100.0)/100.0 + " + " + Math.round(c3.getImaginary()*100.0)/100.0 + "i");
		
		
		//multiplication test
		c3=c1.mult(c2);		
		System.out.println("The multiplication between the numbers is: " + Math.round(c3.getReal()*100.0)/100.0 + " + " + Math.round(c3.getImaginary()*100.0)/100.0 + "i");
		
		
		//division test
		c3=c1.div(c2);
		System.out.println("The division between the numbers is: " + Math.round(c3.getReal()*100.0)/100.0 + " + " + Math.round(c3.getImaginary()*100.0)/100.0 + "i");
		
			
		//module test		
		System.out.println("The module of the number: " + c1.getReal() + " + " + c1.getImaginary() + "i is: " + Math.round(c1.module()*100.0)/100.0);
		
		
		//angle test	
		System.out.println("The angle of the number: " + c1.getReal() + " + " + c1.getImaginary() + "i is: "
				+ Math.round(c1.angle() * 100.0) / 100.0 + "°");


	}
}
