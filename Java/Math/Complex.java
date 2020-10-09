/**
* @author Edoardo Ferrari
* @version 1.0
*
* Class with some functions for operations with complex numbers,
* trig() and theta() are only for representation,
* It can also work with the Frazione class.
*/

import java.util.*;

public class Complex {
	//attributes
	private double real;
	private double im;

	//constructor
	public Complex(double real, double im) {
		this.real = real;
		this.im = im;
	}

	//constructor
	public Complex(double real) {
		this.real = real;
		this.im = 0.0;
	}

	//constructor
	public Complex(double im) {
		this.real = 0.0;
		this.im = im;
	}

        //constructor
	public Complex() {
		this.real = 0.0;
		this.im = 0.0;
	}

	/**
	* returns the sum of two complex as a new complex number
	* @param c Complex
	* @return Complex
	*/
	public Complex sum(Complex c) {
		this.real += c.getReal();
		this.im += c.getIm();
		return new Complex(real, im);
	}

	/**
	* returns the difference of two complex as a new complex number
	* @param c Complex
	* @return Complex
	*/
	public Complex minus(Complex c) {
		this.real -= c.getReal();
		this.im -= c.getIm();
		return new Complex(real, im);
	}

	/**
	* returns the product of two complex numbers
	* @param c Complex
	* @return Complex
	*/
	public Complex mult(Complex c) {
		this.real = this.real * c.getReal() - this.im * c.getIm();
		this.im = this.real * c.getIm() + this.im * c.getReal();
		return new Complex(real, im);
	}

	/**
	* returns the product of a Complex number and a double
	* @param alpha double
	* @return Complex
	*/
    public Complex prod(double d) {
        return new Complex(this.real * d, this.im * d);
    }

    /**
    * returns the module of the Complex number
    * @return double
    */
	public double mod() {
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.im, 2));
	}

	/**
	* returns the conjugate of the Complex number
	* @return Complex
	*/
	public Complex conj() {
		return new Complex(this.real, -(this.im));
	}

	/**
	* returns the angle of the Complex number
	* @return  double
	*/
	public double angle() {
		return Math.atan2(real, im);
	}

    /**
    * returns the theta of the Complex number (-pi, +pi]
    * @return String
    */
	public String theta() {
		if(this.real == 0 && this.im > 0) {
			return "\u03C0" + "/2";
		}

		if(this.real == 0 && this.im < 0) {
			return "- (" + "\u03C0" + "/2)";
		}

		if(this.real == 0 && this.im == 0) {
			return "undefined";
		}

		if(this.real > 0) {
			return String.valueOf(Math.atan(this.im/this.real));
		}

		if(this.real < 0 && this.im >= 0) {
			return String.valueOf(Math.atan(this.im/this.real)) + " + " + "\u03C0" + "/2";
		}

		if(this.real < 0 && this.im < 0) {
			return String.valueOf(Math.atan(this.im/this.real)) + " - (" + "\u03C0" + "/2)";
		}

		else {
			return "cannot calculate theta";
		}
	}

	/**
	* returns the trigonometric function
	* @return String
	*/
	public String trig() {
		return "z = " + String.valueOf(this.mod()) + " * (" + "cos(" + this.theta() + ")" + " + " + "isen(" + this.theta() + ")" + ")^(1/2)";
	}

	/**
	* returns the real part of a Complex
	* @return double
	*/
	public double getReal() {
		return this.real;
	}

	/**
	* returns the imaginary part of a Complex
	* @return double
	*/
	public double getIm() {
		return this.im;
	}

	/**
	* returns the Complex number as a String
	* @return String
	*/
	@Override
	public String toString() {
		if(this.real == 0 && this.im == 0) {
			return "z = 0";
		}

		if(this.real == 0 && this.im != 0) {
			if(this.im < 0) {
				return "z = -" + (-(this.im));
			}

			else {
				return "z = " + this.im;
			}
		}

		if(this.real != 0 && this.im == 0) {
			return "z = " + this.real;
		}

		if(this.real != 0 && this.im != 0) {
			if(this.im < 0) {
				return "z = " + this.real + " - " + (-(this.im));
			}

			else {
				return "z = " + this.real + " + " + this.im;
			}
		}

		return "wrong formatting";
	}

	/**
	* Override of the equals method
	* @param o Object
	* @return true if equals
	*/
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o instanceof Complex) {
			Complex c = (Complex) o;
			if(this.real == c.getReal() && this.im == c.getIm()) {
				return true;
			}
			
			else {
				return false;
			}
		}
		
		else {
			return false;
		}
	}

	/**
	* returns the HashCode
	* @return int
	*/
	@Override
	public int hashCode() {
		return this.toString().hashCode() * 31;
	}
}
