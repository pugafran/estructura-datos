package estdatos;
import java.util.Iterator;
import java.util.LinkedList;

public class InternalIterator<T> implements IterableExtends {
	
	private Iterable<T> itr;
	
	public InternalIterator(Iterable<T> it){
		itr = it;
	}
	
	public Iterator<T> iterator(){
		
		return itr.iterator();
	}
    

}
