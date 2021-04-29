package teste5;

public class Complex {

	private double realComplex;

	private double imaginaryComplex;
	
	public Complex() {
		
		realComplex = 0;
		imaginaryComplex = 0;
		
	}
	
	public Complex (double imaginaryComplex) {
		
		this.imaginaryComplex = 0;
		
	}
	
	public Complex(double realComplex, double imaginaryComplex) {
		
		this.realComplex = realComplex;
		this.imaginaryComplex = imaginaryComplex;
		
	}
	
	public void setComplex(double a, double b) {

		realComplex = a;
		imaginaryComplex = b;

	}

	public double getReal() {

		return realComplex;

	}

	public double getImaginary() {

		return imaginaryComplex;
	}

	public Complex addToMe(Complex n) {

		realComplex = realComplex + n.realComplex;
		imaginaryComplex = imaginaryComplex + n.imaginaryComplex;
		return this;

	}

	public Complex subtractFromMe(Complex n) {

		realComplex = realComplex - n.realComplex;
		imaginaryComplex = imaginaryComplex - n.imaginaryComplex;
		return this;

	}

	public Complex multiplyByMe(Complex n) {
		
		double auxRealComplex = realComplex;
		realComplex = realComplex * n.realComplex -imaginaryComplex*n.imaginaryComplex;
		imaginaryComplex = auxRealComplex*n.imaginaryComplex + imaginaryComplex*n.realComplex;
		return this;

	}

	public Complex divideMeBy(Complex n) {
		


		double auxRealComplex = realComplex;
		double auxImaginaryComplex = imaginaryComplex;
		double modn = n.module();

		auxRealComplex = ((realComplex * n.realComplex) + (imaginaryComplex * n.imaginaryComplex))
				/ Math.pow(modn, 2);
		auxImaginaryComplex = ((imaginaryComplex * n.realComplex) - (realComplex * n.imaginaryComplex))
				/ Math.pow(modn, 2);
		
		realComplex = auxRealComplex;
		imaginaryComplex = auxImaginaryComplex;

		return this;


	}
	
	public Complex add(Complex n) {

		Complex auxAdd = new Complex();

		auxAdd.realComplex = n.realComplex;
		auxAdd.imaginaryComplex = n.imaginaryComplex;

		auxAdd.realComplex = realComplex + n.realComplex;
		auxAdd.imaginaryComplex = imaginaryComplex + n.imaginaryComplex;

		return auxAdd;

	}

	public Complex sub(Complex n) {

		Complex auxSub = new Complex();

		auxSub.realComplex = n.realComplex;
		auxSub.imaginaryComplex = n.imaginaryComplex;

		auxSub.realComplex = realComplex - n.realComplex;
		auxSub.imaginaryComplex = imaginaryComplex - n.imaginaryComplex;

		return auxSub;

	}

	public Complex mult(Complex n) {

		Complex auxMult = new Complex();

		auxMult.realComplex = n.realComplex;
		auxMult.imaginaryComplex = n.imaginaryComplex;

		auxMult.realComplex = (realComplex * n.realComplex) - (imaginaryComplex * n.imaginaryComplex);
		auxMult.imaginaryComplex = (realComplex * n.imaginaryComplex) + (imaginaryComplex * n.realComplex);

		return auxMult;

	}

	public Complex div(Complex n) {

		Complex auxDiv = new Complex();

		auxDiv.realComplex = n.realComplex;
		auxDiv.imaginaryComplex = n.imaginaryComplex;
		double modn = n.module();

		auxDiv.realComplex = ((realComplex * n.realComplex) + (imaginaryComplex * n.imaginaryComplex))
				/ Math.pow(modn, 2);
		auxDiv.imaginaryComplex = ((imaginaryComplex * n.realComplex) - (realComplex * n.imaginaryComplex))
				/ Math.pow(modn, 2);

		return auxDiv;

	}

	public double module() {

		double mod;

		mod = Math.sqrt(Math.pow(realComplex, 2) + Math.pow(imaginaryComplex, 2));

		return mod;

	}

	// returns angle value in degree
	public double angle() {

		double ang;
		
		if(imaginaryComplex == 0) return 0;
		
		else if (realComplex == 0) return 90;

		ang = Math.toDegrees(Math.atan(imaginaryComplex/realComplex));
		
		if(imaginaryComplex > 0 && realComplex > 0) return ang;
		
		else if(imaginaryComplex > 0 && realComplex < 0) return (180+ang);
			
		else if(imaginaryComplex < 0 && realComplex > 0) return (ang+360);
						
		else return (180+ang);
	}

}
