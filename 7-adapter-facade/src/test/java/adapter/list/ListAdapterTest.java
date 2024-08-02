package adapter.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListAdapterTest {
    ListAdapter listAdapter;

    @BeforeEach
    public void setUp() {
        Lista lista = new Lista();
        listAdapter = new ListAdapter(lista);
    }

    @Test
    public void testAddSizeContains() {
        int addedNumber = 1;
        listAdapter.add(addedNumber);

        assert (listAdapter.size() == 1);
        assert (listAdapter.contains(addedNumber));
    }

    @Test
    public void testRemove() {
        int addedNumber = 1;
        listAdapter.add(addedNumber);
        listAdapter.remove(0);

        assert (listAdapter.isEmpty());
    }

    @Test
    public void testGet() {
        int addedNumber = 1;
        listAdapter.add(addedNumber);

        assertEquals(addedNumber, listAdapter.get(0));
    }

    @Test
    public void testClear() {
        for (int i = 0; i < 10; i++) {
            listAdapter.add(i);
        }

        listAdapter.clear();

        assert (listAdapter.isEmpty());
    }
}
