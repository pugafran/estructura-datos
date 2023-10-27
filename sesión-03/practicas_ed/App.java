package practicas_ed;

import java.util.Collection;

import estdatos.ListBag;
import estdatos.ListBagSort;

public class App {

	public static void main(String[] args) {
		Collection<Character> c1 = new ListBag<>();
		
		c1.add('f');
		c1.add('t');
		c1.add('a');
		c1.add('q');
		c1.add('s');
		c1.add('a');
		c1.add('c');
		c1.add('r');
		c1.add('s');
		c1.add('b');
		
		Collection<Character> c2 = new ListBagSort<>(c1);
		Collection<Character> c3 = new ListBagSort<>(c2);
		Collection<Character> c4 = new ListBagSort<>(c1,
				(ch1, ch2) -> { return -ch1.compareTo(ch2); });
		
		System.out.printf("c1: %s\n", c1);
		System.out.printf("c2: %s\n", c2);
		System.out.printf("c3: %s\n", c3);
		System.out.printf("c4: %s\n", c4);
		System.out.printf("c3 == c2 ? %b\n", c3.equals(c2));
		System.out.printf("c3 == c4 ? %b\n", c3.equals(c4));
	}

}
