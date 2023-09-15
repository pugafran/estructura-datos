package estdatos;

/**
 * Tipo inmutable de racionales.
 */
public class ImmutableRational extends AbstractRational {
    /**
     * El par {@code (numerador, denominador)}.
     */
    private Pair<Integer, Integer> p;

    /**
     * Crea el racional {@code n/d}. El signo se establece
	 * en el numerador.
     *
     * @param n el numerador del racional
     * @param d el denominador del racional
     * @throws IllegalArgumentException si el denominador
     * es cero
     */
    public ImmutableRational(final int n, final int d) {
		
    	if(d == 0)
    		throw new IllegalArgumentException("No se puede dividir entre 0");
    	
    	else if(d < 0)
    		this.p = new ImmutablePair<>(-n,Math.abs(d));
    	
    	else
    		this.p = new ImmutablePair<>(n,d);
    }

    /**
     * Constructor de conversión.
     *
     * @param r el racional a copiar
     */
    public ImmutableRational(final Rational r) {

    }

	@Override
	public int numerator() {
		// TODO Auto-generated method stub
		return p.first();
	}

	@Override
	public int denominator() {
		// TODO Auto-generated method stub
		return p.second();
	}

	@Override
	public int compareTo(Rational b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
