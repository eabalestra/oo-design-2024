package immutablelist;

import java.util.AbstractList;
import java.util.Arrays;

public class ImmutableArrayList<E> extends AbstractList<E> {
    E[] elements;

    public ImmutableArrayList(E[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= elements.length)
            throw new IndexOutOfBoundsException("Index: "+i+", Size: "+elements.length);
        return elements[i];
    }

    @Override
    public int size() {
        return elements.length;
    }
}
