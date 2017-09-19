package recursion;

import java.util.*;

public class ArrayPermutations {
    short permutations = 0;

    void permuteList(List<Integer> list, int fixedPosition) {
        if(fixedPosition >= list.size()) {
            System.out.println(Arrays.toString(list.toArray()));
            permutations++;
            return;
        }
        permuteList(list, fixedPosition +1);
        for( int i=fixedPosition +1; i < list.size(); i++ ) {
            list = swap(list, fixedPosition, i);
            permuteList(list, fixedPosition +1);
            list = swap(list, i, fixedPosition);
        }
    }

    List<Integer> swap(List<Integer> list, int i, int j) {
        List<Integer> swappedList = new ArrayList<Integer>(list);
        Integer temp  = list.get(i);
        swappedList.set(i, list.get(j));
        swappedList.set(j, temp);
        return swappedList;
    }

    public static void main(String[] args) {
        ArrayPermutations permutations = new ArrayPermutations();
        Integer[] array = { 1,2,3,4 };
        permutations.permuteList(Arrays.asList(array), 0);
        System.out.println("Permutations: " + permutations.permutations);
    }
}
