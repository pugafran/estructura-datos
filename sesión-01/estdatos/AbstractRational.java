package estdatos;

import java.util.Objects;

/**
 * Clase abstracta para racionales.
 */
public abstract class AbstractRational implements Rational {
	private final static Object obj = new Object();
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = obj.hashCode();
		result = prime * result + Objects.hash(this.numerator(), this.denominator());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Rational))
			return false;
		Rational other = (Rational) obj;
		return gcd(this.numerator(), this.denominator()) == gcd(other.numerator(), other.denominator());
	}
    
	
	public void reduce() {
		int mcd = gcd(this.numerator(),this.denominator());	
		this.setNumerator(this.numerator()/mcd);
		this.setDenominator(this.denominator()/mcd);
	
		
	}

	@Override
	public String toString() {
		
		if (this.denominator() == 1) 
			return this.numerator() + "";
		
		else
			return this.numerator() + "/" + this.denominator();
	
	}
	
    static int gcd(final int a, final int b) {
    	if (a == 0 || b == 0) {
    		throw new IllegalArgumentException();
    	}
    	
        int n1 = a > 0 ? a : -a;
        int n2 = b > 0 ? b : -b;

        while (n2 != 0) {
            int temp = n1;
            n1 = n2;
            n2 = temp % n2;
        }

        return n1;
    }

	public int compareTo(Rational b) {
		// TODO Auto-generated method stub
		return 0;
	}
}
