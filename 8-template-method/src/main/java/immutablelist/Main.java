package immutablelist;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ImmutableArrayList<Integer> immutableArrayList = new ImmutableArrayList<>(new Integer[]{1, 2, 3});
        AbstractList<Integer> abstractList = new ArrayList<>(Arrays.asList(1, 2, 3));

        System.out.println("-- ARRAYLISTS --");
        System.out.println("AbstractList: " + abstractList);
        System.out.println("ImmutableArrayList: " + immutableArrayList);
        
        boolean bool = Arrays.equals(immutableArrayList.toArray(), abstractList.toArray());
        System.out.println("\nArrays are equal: " + bool);

        System.out.println("\nImmutableArrayList contains 2: " + immutableArrayList.contains(2));
        System.out.println("Index of 3 in ImmutableArrayList: " + immutableArrayList.indexOf(3));
        System.out.println("Last index of 2 in ImmutableArrayList: " + immutableArrayList.lastIndexOf(2));
    }
}
