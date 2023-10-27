import java.util.*;

public class ListBag<E> extends AbstractCollection<E> {
    // Campo protegido data de tipo List<E>
    protected List<E> data;

    // Constructor por defecto
    public ListBag() {
        this.data = new LinkedList<>();
    }

    // Constructor que recibe una colección
    public ListBag(Collection<? extends E> c) {
        this.data = new LinkedList<>(c);
        // Aseguramos que no contenga elementos null
        if (this.data.contains(null)) {
            throw new NullPointerException("No se permiten elementos null");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("No se permite agregar elementos null");
        }
        return data.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return data.remove(o);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    // Puede ser necesario implementar/redefinir más métodos dependiendo de las características deseadas.
}

