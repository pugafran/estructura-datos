package estdatos;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface IterableExtends<T> extends Iterable<T> {



	/*
	 	@Override
default void forAll(Consumer<? super T> action) {
    for (T item : this) {
        action.accept(item);
    }
}

default void forEachFiltered(Consumer<? super T> action, Predicate<? super T> filter) {
    for (T item : this) {
        if (filter.test(item)) {
            action.accept(item);
        }
    }
}

	 */


	/**
	 * Realiza la acción especificada con todos los elementos
	 * que proporciona el iterador, uno a uno.
	 * @param action la acción a realizar
	 */
	default void forAll(Consumer<? super T> action) {
		// Implementar utilizando un iterador de forma explícita
		Iterator<T> iterator = this.iterator();

		while (iterator.hasNext()) {
			action.accept(iterator.next());
		}


	}

	/**
	 * Realiza la acción especificada con todos los elementos
	 * que cumplen el filtro dado.
	 * @param action la acción a realizar
	 * @param filter el filtro proporcionado
	 */
	default void forEachFiltered(Consumer<? super T> action,
			Predicate<? super T> filter) {
		// Implementar utilizando un iterador de forma explícita
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext()) {
			T item = iterator.next();
			if (filter.test(item)) {
				action.accept(item);
			}
		}

	}

	/**
	 * Retorna el resultado acumulado de aplicar la función
	 * especificada a los elementos que proporciona el
	 * iterador, uno a uno.
	 * @param f la función dada
	 * @return si {@code A0, A1, A2, ...An-1} son los
	 * ítems que proporciona el iterador, el valor de
	 * {@code f(...f(f(A1, f(A0)), A2), An-1) }
	 * @throws IllegalStateException si este objeto iterable
	 * está vacío (el iterador no tiene ítems que proporcionar)
	 */
	default T reduceAll(BiFunction<T, T, T> f) {


		// [1 2 3 4 5]
		// Entero Entero Entero funcion sumar
		// Implementar utilizando un iterador de forma explícita
		Iterator<T> iterator = this.iterator();

		if (!iterator.hasNext()) {
			throw new IllegalStateException("El objeto iterable está vacío");
		}

		//result = 1
		T result = iterator.next();

		while (iterator.hasNext()) {

			//result = aplica una funcion a result y el siguiente , si es la suma por ejemplo: (1 + 2) (3 + 3) (6 + 4)
			result = f.apply(result, iterator.next());
		}

		return result;
	}

	/**
	 * Retorna el resultado acumulado de aplicar la función
	 * especificada a los elementos que cumplen el filtro dado.
	 * @param f la función dada
	 * @param filter el filtro especificado
	 * @return si {@code a, b, c, ..., k} son los elementos que
	 * proporcina el iterador y cumplen el filtro dado, el valor
	 * {@code f(...f(f(b, f(a)), c), k) }
	 * @throws IllegalStateException si este objeto iterable
	 * está vacío (el iterador no tiene ítems que proporcionar) o
	 * ningún ítem cumple el filtro dado
	 */
	default T reduceFiltered(BiFunction<T, T, T> f,
			Predicate<? super T> filter) {
		// Implementar utilizando un iterador de forma explícita
		Iterator<T> iterator = this.iterator();

		boolean hasValidElement = false;

		T result = null;

		while (iterator.hasNext()) {
			T item = iterator.next();
			if (filter.test(item)) {
				if (!hasValidElement) {
					result = item;
					hasValidElement = true;
				} else {
					result = f.apply(result, item);
				}
			}
		}

		if (!hasValidElement) {
			throw new IllegalStateException("El objeto iterable está vacío o ningún ítem cumple el filtro dado");
		}

		return result;
	}

	/**
	 * Elimina todos los ítems de este objeto iterable,
	 * lo deja vacío.
	 * @throws UnsupportedOperationException si esta operación
	 * no está soportada
	 */
	default void removeAll() {

		Iterator<T> iterator = this.iterator();

		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}

	}

	/**
	 * Elimina de este objeto iterable todos los ítems que
	 * cumplen el filtro especificado.
	 * @param filter el filtro dado
	 * @throws UnsupportedOperationException si esta operación
	 * no está soportada
	 */
	default void removeFiltered(Predicate<? super T> filter) {

		Iterator<T> iterator = this.iterator();

		while (iterator.hasNext()) {
			T item = iterator.next();
			if (filter.test(item)) {
				iterator.remove();
			}
		}

	}

}
