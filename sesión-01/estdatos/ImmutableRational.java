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
		
    }

    /**
     * Constructor de conversión.
     *
     * @param r el racional a copiar
     */
    public ImmutableRational(final Rational r) {

    }

}
