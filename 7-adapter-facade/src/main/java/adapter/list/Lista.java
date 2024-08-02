package adapter.list;

import java.util.Arrays;

public class Lista {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;
    private int[] elements;

    public Lista() {
        elements = new int[DEFAULT_CAPACITY];
    }

    public boolean agregar(int element) {
        if (size == elements.length) {
            agregarCapacidad();
        }
        elements[size++] = element;
        return true;
    }

    public int tomar(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid Index: ");
        }
        return elements[index];
    }

    public int eliminar(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid Index: ");
        }
        int item = elements[index];
        int numElts = elements.length - (index + 1);
        System.arraycopy(elements, index + 1, elements, index, numElts);
        size--;
        return item;
    }

    public int longitud() {
        return size;
    }

    private void agregarCapacidad() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();

    }

    public boolean contiene(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void limpiar() {
        for (int i = 0; i < size; i++) {
            elements[i] = 0;
        }
        size = 0;
    }
}