package adapter.list;

import java.util.List;

public class ListTestDrive {

    public static void main(String[] args) {
        Lista lista = new Lista();
        List<Integer> listAdapter = new ListAdapter(lista);

        for (int i = 0; i < 10; i++) {
            listAdapter.add(i);
        }
        System.out.println("Lista: " + listAdapter.toString());

        for (int i = 0; i < 2; i++) {
            listAdapter.remove(i);
        }
        System.out.println("Lista: " + listAdapter.toString());

    }
}
