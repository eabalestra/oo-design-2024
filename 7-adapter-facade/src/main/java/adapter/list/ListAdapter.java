package adapter.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListAdapter implements List {
    Lista lista;

    public ListAdapter(Lista lista) {
        this.lista = lista;
    }

    @Override
    public boolean add(Object o) {
        return lista.agregar((int) o);
    }

    @Override
    public Object remove(int i) {
        return lista.eliminar(i);
    }

    @Override
    public int size() {
        return lista.longitud();
    }

    @Override
    public boolean isEmpty() {
        return lista.longitud() == 0;
    }

    @Override
    public String toString() {
        return lista.imprimir();
    }

    @Override
    public boolean contains(Object o) {
        return lista.contiene((int) o);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return false;
    }

    @Override
    public void clear() {
        lista.limpiar();
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public Object get(int i) {
        return lista.tomar(i);
    }

    @Override
    public Object set(int i, Object o) {
        return null;
    }

    @Override
    public void add(int i, Object o) {

    }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }


    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @Override
    public List subList(int i, int i1) {
        return List.of();
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }
}
