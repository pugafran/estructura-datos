import java.util.Comparator;
import java.util.Objects;

public class ListBagSort<E> extends ListBag<E> {

    private Comparator<? super E> cmp;

    // Constructor que utiliza el orden natural
    public ListBagSort() {
        this.cmp = null;
    }

    // Constructor que utiliza un comparador proporcionado
    public ListBagSort(Comparator<? super E> cmp) {
        this.cmp = cmp;
    }

    public ListBagSort(Collection<? extends E> c) {
        this();  // Utiliza el orden natural
        addAll(c);
    }
    
    public ListBagSort(Collection<? extends E> c, Comparator<? super E> comparator) {
        this(comparator);  // Utiliza el comparador proporcionado
        addAll(c);
    }
    
    

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("No se permite agregar elementos null");
        }

        int insertIndex = 0;
        for (E element : data) {
            if (compare(e, element) > 0) {
                insertIndex++;
            } else {
                break;
            }
        }

        data.add(insertIndex, e);
        return true;
    }

    public int compare(E a, E b) {
        if (cmp == null) {
            Comparable<E> ca = (Comparable<E>) a;
            return ca.compareTo(b);
        } else {
            return cmp.compare(a, b);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListBagSort)) return false;
        ListBagSort<?> that = (ListBagSort<?>) o;
        return Objects.equals(data, that.data) &&
               Objects.equals(cmp, that.cmp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, cmp);
    }
}
