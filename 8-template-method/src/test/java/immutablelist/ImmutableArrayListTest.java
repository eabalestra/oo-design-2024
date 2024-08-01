package immutablelist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableArrayListTest {
    List<Integer> list;

    @BeforeEach
    void setUp() {}

    @Test
    void getReturnsCorrectElement() {
        list = new ImmutableArrayList<>(new Integer[]{1, 2, 3});

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void getThrowsIndexOutOfBoundsException() {
        list = new ImmutableArrayList<>(new Integer[]{1, 2, 3});

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    void sizeReturnsCorrectSize() {
        list = new ImmutableArrayList<>(new Integer[]{1, 2, 3});

        assertEquals(3, list.size());
    }

    @Test
    void isEmptyReturnsTrueForEmptyList() {
        list = new ImmutableArrayList<>(new Integer[]{});

        assertTrue(list.isEmpty());
    }

    @Test
    void isEmptyReturnsFalseForNonEmptyList() {
        list = new ImmutableArrayList<>(new Integer[]{1, 2, 3});

        assertFalse(list.isEmpty());
    }

    @Test
    void containsReturnsTrueForElementInList() {
        list = new ImmutableArrayList<>(new Integer[]{1, 2, 3});

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
    }

    @Test
    void containsReturnsFalseForElementNotInList() {
        list = new ImmutableArrayList<>(new Integer[]{1, 2, 3});

        assertFalse(list.contains(4));
    }

    @Test
    void indexOfReturnsCorrectIndex() {
        list = new ImmutableArrayList<>(new Integer[]{1, 2, 3});

        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.indexOf(3));
    }

    @Test
    void indexOfReturnsMinusOneForElementNotInList() {
        list = new ImmutableArrayList<>(new Integer[]{1, 2, 3});

        assertEquals(-1, list.indexOf(4));
    }

    @Test
    void lastIndexOfReturnsCorrectIndex() {
        list = new ImmutableArrayList<>(new Integer[]{1, 2, 3, 2});

        assertEquals(3, list.lastIndexOf(2));
    }

    @Test
    void lastIndexOfReturnsMinusOneForElementNotInList() {
        list = new ImmutableArrayList<>(new Integer[]{1, 2, 3});

        assertEquals(-1, list.lastIndexOf(4));
    }
}