package recursion;

/**
 * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of
 * one group is a multiple of 10, and the sum of the other group is odd. Every int must be in one
 * group or the other. Write a recursive helper method that takes whatever arguments you like, and
 * make the initial call to your recursive helper from splitOdd10(). (No loops needed.)
 *
 * splitOdd10([5, 5, 5]) → true
 * splitOdd10([5, 5, 6]) → false
 * splitOdd10([5, 5, 6, 1]) → true
 */
public class SplitOddTen {
    public boolean splitOdd10(int[] nums) {
        return isSplitPossible(0, nums, sumOfArray(0, nums), 0);
    }

    public int sumOfArray(int index, int[] array) {
        if(index >= array.length) return 0;
        else return array[index] + sumOfArray(index+1, array);
    }

    public boolean isSplitPossible(int index, int[] array, int sumFirst, int sumSecond) {
        if(index >= array.length) return (sumFirst %2 == 0 && sumSecond % 10 == 0);
        if(isSplitPossible(index +1, array, sumFirst, sumSecond)) return true;
        if(isSplitPossible(index +1, array, sumFirst - array[index], sumSecond - array[index])) {
            return true;
        }
        return false;
    }
}
