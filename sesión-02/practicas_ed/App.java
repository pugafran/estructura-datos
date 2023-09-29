package practicas_ed;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import estdatos.IterableExtends;
import estdatos.InternalIterator;

public class App {
	private final static Iterable<String> CSTR =
			Stream.of("esto", "es", "un stream", "formado", "por",
					  "varias", "cadenas", "de", "caracteres").collect(
							  Collectors.toCollection(LinkedList::new));
	
	public static void main(String[] args) {

		/* 
		 *  Utilizando un iterador interno (objeto de tipo
		 *  InternalIterator<String>)
		 */
		
		IterableExtends<String> String = new InternalIterator<>(CSTR);
		
		System.out.println("\n\tCon iteradores internos");
		System.out.println("\t-----------------------");
		
		// Muestra en consola las cadenas de la colección CSTR	
		String.forAll(
				
				(texto) -> {
					System.out.printf(" \"%s\"",texto);
				}
				
				);
		
		System.out.println("\n\nAhora cadenas de CSTR con más de 5 caracteres:");
		
		// Cadenas de CSTR con más de 5 caracteres
		String.forEachFiltered(
				
				
			  (texto) -> {System.out.printf(" \"%s\"", texto);},
			  
			  
			  (texto) -> {return texto.length() > 5;}
				
				
				);

		
		// Menor cadena de la colección CSTR
		String menor = String.reduceAll(  (str1, str2) -> {
			
			//orden natural de los string para java alfabetico
			return (str1.compareTo(str2) <= 0 ? str1 : str2);
			
			
		}
		
				
				);

		
		System.out.println(menor);
		
		// Concatenación de las cadenas de CSTR con más de 5 caracteres.
		// Éstas se concatenan según el orden en que las proporciona un
		// iterador.


		System.out.println("\n\n\tEliminando ítems de un objeto iterable");
		System.out.println("\t--------------------------------------");
		// La colección CSTR es constante y no se puede modificar, por
		// lo que se crea una nueva colección, list, igual que CSTR que
		// si se pueda modificar
		Iterable<String> list = new LinkedList<>((List<String>)CSTR);
		System.out.printf("list.equals(CSTR)? %b\n", list.equals(CSTR));
		
		// Eliminar de list todas las cadenas que tengan menos de 3
		// caracteres o comiencen por el carácter 'c'.

		
		// Mostrar en consola las cadenas de la colección list	
		// utilizando el iterador ímplicito (bucle for-each)



		/* 
		 *  Utilizando un iterador externo (objeto de tipo
		 *  Iterator<String>) 
		 */
		System.out.println("\n\tCon iteradores externos");
		System.out.println("\t-----------------------");
		
		// Muestra en consola las cadenas de la colección CSTR

		
		// Cadenas de CSTR con más de 5 caracteres

		
		// Menor cadena de la colección CSTR


		// Concatenación de las cadenas de CSTR con más de 5 caracteres.
		// Éstas se concatenan según el orden en que las proporciona un
		// iterador.


	}

}
